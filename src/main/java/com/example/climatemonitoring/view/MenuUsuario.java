package com.example.climatemonitoring.view;

import com.example.climatemonitoring.models.Notificacao;
import com.example.climatemonitoring.models.Usuario;
import com.example.climatemonitoring.models.observers.UsuarioObserver;
import com.example.climatemonitoring.service.ClimaService;
import com.example.climatemonitoring.service.NotificacaoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Menu do usuário logado, com opções para ver boletim climático, análise de
 * risco e histórico.
 * Segue o princípio SRP ao ter apenas a responsabilidade de gerenciar o menu do
 * usuário.
 * Segue o princípio DIP ao depender de abstrações (serviços) injetadas via
 * construtor.
 */

@Component
public class MenuUsuario {
    private TerminalUtil terminal;
    private ClimaService climaService;
    private NotificacaoService notificacaoService;

    @Autowired
    public MenuUsuario(TerminalUtil terminal, ClimaService climaService, NotificacaoService notificacaoService) {
        this.terminal = terminal;
        this.climaService = climaService;
        this.notificacaoService = notificacaoService;
    }

    /**
     * Exibe o menu do usuário logado.
     * 
     * @param usuario Usuário logado
     */
    public void exibir(Usuario usuario) {
        // Cria um observador para o usuário
        UsuarioObserver observador = new UsuarioObserver(usuario);

        // Adiciona o observador para receber notificações
        climaService.adicionarObservador(observador);

        // Envia um boletim automático ao logar
        String boletimAutomatico = climaService.gerarBoletimClimatico("Luís Eduardo Magalhães");
        climaService.notificarObservadores(boletimAutomatico);
        notificacaoService.registrarNotificacao(boletimAutomatico);

        boolean sair = false;

        while (!sair) {
            terminal.limparTela();
            terminal.exibirMensagem("Bem-vindo, " + usuario.getNome() + "!");
            terminal.exibirMensagem("1. Ver boletim climático atual");
            terminal.exibirMensagem("2. Ver análise de risco");
            terminal.exibirMensagem("3. Ver histórico de notificações");
            terminal.exibirMensagem("0. Logout");

            int opcao = terminal.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    verBoletimClimatico();
                    break;
                case 2:
                    verAnaliseRisco();
                    break;
                case 3:
                    verHistoricoNotificacoes();
                    break;
                case 0:
                    sair = true;
                    // Remove o observador ao fazer logout
                    climaService.removerObservador(observador);
                    break;
                default:
                    terminal.exibirMensagem("Opção inválida!");
                    terminal.pausar();
            }
        }
    }

    /**
     * Exibe o boletim climático atual.
     */
    private void verBoletimClimatico() {
        terminal.limparTela();
        terminal.exibirMensagem("=== Boletim Climático Atual ===");

        String boletim = climaService.gerarBoletimClimatico("Luís Eduardo Magalhães");
        terminal.exibirMensagem(boletim);

        terminal.pausar();
    }

    /**
     * Exibe a análise de risco para plantio.
     */
    private void verAnaliseRisco() {
        terminal.limparTela();
        terminal.exibirMensagem("=== Análise de Risco para Plantio ===");

        String[] analise = climaService.obterAnaliseRisco("Luís Eduardo Magalhães");
        for (String dia : analise) {
            terminal.exibirMensagem(dia);
        }

        terminal.pausar();
    }

    /**
     * Exibe o histórico de notificações.
     */
    private void verHistoricoNotificacoes() {
        terminal.limparTela();
        terminal.exibirMensagem("=== Histórico de Notificações ===");

        List<Notificacao> historico = notificacaoService.listarHistorico();

        if (historico.isEmpty()) {
            terminal.exibirMensagem("Nenhuma notificação registrada.");
        } else {
            for (int i = 0; i < historico.size(); i++) {
                terminal.exibirMensagem((i + 1) + ". " + historico.get(i).getMensagem());
                terminal.exibirMensagem("---");
            }
        }

        terminal.pausar();
    }
}
