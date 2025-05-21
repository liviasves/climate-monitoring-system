package com.example.climatemonitoring.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.climatemonitoring.models.Usuario;
import com.example.climatemonitoring.service.UsuarioService;

/**
 * Menu principal do sistema, com opções de login, cadastro e listagem de
 * usuários.
 * Segue o princípio SRP ao ter apenas a responsabilidade de gerenciar o menu
 * principal.
 * Segue o princípio DIP ao depender de abstrações (serviços) injetadas via
 * construtor.
 */

@Component
public class MenuPrincipal {
    private TerminalUtil terminal;
    private UsuarioService usuarioService;
    private MenuUsuario menuUsuario;

    @Autowired
    public MenuPrincipal(TerminalUtil terminal, UsuarioService usuarioService, MenuUsuario menuUsuario) {
        this.terminal = terminal;
        this.usuarioService = usuarioService;
        this.menuUsuario = menuUsuario;
    }

    /**
     * Exibe o menu principal do sistema.
     */
    public void exibir() {
        boolean sair = false;

        while (!sair) {
            terminal.limparTela();
            terminal.exibirMensagem("Sistema de Monitoramento Climático");
            terminal.exibirMensagem("1. Fazer login");
            terminal.exibirMensagem("2. Cadastrar novo usuário");
            terminal.exibirMensagem("3. Listar todos os usuários");
            terminal.exibirMensagem("0. Sair");

            int opcao = terminal.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    fazerLogin();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    listarUsuarios();
                    break;
                case 0:
                    sair = true;
                    terminal.exibirMensagem("Obrigado por utilizar o Sistema de Monitoramento Climático!");
                    break;
                default:
                    terminal.exibirMensagem("Opção inválida!");
                    terminal.pausar();
            }
        }
    }

    /**
     * Realiza o login de um usuário.
     */
    private void fazerLogin() {
        terminal.limparTela();
        terminal.exibirMensagem("=== Login ===");

        String email = terminal.lerString("Email: ");
        String senha = terminal.lerString("Senha: ");

        Usuario usuario = usuarioService.autenticar(email, senha);

        if (usuario != null) {
            terminal.exibirMensagem("Login realizado com sucesso!");
            terminal.pausar();
            menuUsuario.exibir(usuario);
        } else {
            terminal.exibirMensagem("Email ou senha incorretos!");
            terminal.pausar();
        }
    }

    /**
     * Cadastra um novo usuário.
     */
    private void cadastrarUsuario() {
        terminal.limparTela();
        terminal.exibirMensagem("=== Cadastro de Usuário ===");

        String nome = terminal.lerString("Nome: ");
        String email = terminal.lerString("Email: ");
        String senha = terminal.lerString("Senha: ");

        boolean sucesso = usuarioService.cadastrar(nome, email, senha);

        if (sucesso) {
            terminal.exibirMensagem("Usuário cadastrado com sucesso!");

            // Após cadastro, faz login automático
            Usuario usuario = usuarioService.autenticar(email, senha);
            if (usuario != null) {
                terminal.exibirMensagem("Login automático realizado!");
                terminal.pausar();
                menuUsuario.exibir(usuario);
            }
        } else {
            terminal.exibirMensagem("Erro ao cadastrar usuário. Email já existe!");
            terminal.pausar();
        }
    }

    /**
     * Lista todos os usuários cadastrados.
     */
    private void listarUsuarios() {
        terminal.limparTela();
        terminal.exibirMensagem("=== Usuários Cadastrados ===");

        java.util.List<Usuario> usuarios = usuarioService.listarTodos();

        if (usuarios.isEmpty()) {
            terminal.exibirMensagem("Nenhum usuário cadastrado.");
        } else {
            for (Usuario usuario : usuarios) {
                terminal.exibirMensagem(usuario.getNome() + " (" + usuario.getEmail() + ")");
            }
        }

        terminal.pausar();
    }
}
