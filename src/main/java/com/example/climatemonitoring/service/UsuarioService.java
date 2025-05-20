package com.example.climatemonitoring.service;

import com.example.climatemonitoring.data.UsuarioRepository;
import com.example.climatemonitoring.models.Usuario;

import java.util.List;

/**
 * Serviço para gerenciamento de usuários.
 * Segue o princípio SRP ao ter apenas a responsabilidade de gerenciar usuários.
 * Segue o princípio DIP ao depender de abstrações (repositório) injetadas via construtor.
 */
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    /**
     * Autentica um usuário pelo email e senha.
     * 
     * @param email Email do usuário
     * @param senha Senha do usuário
     * @return Usuário autenticado ou null se não encontrado
     */
    public Usuario autenticar(String email, String senha) {
        Usuario usuario = usuarioRepository.buscarPorEmail(email);
        if (usuario != null && senha.equals("senha")) { // Simulação de autenticação
            return usuario;
        }
        return null;
    }
    
    /**
     * Cadastra um novo usuário.
     * 
     * @param nome Nome do usuário
     * @param email Email do usuário
     * @param senha Senha do usuário
     * @return true se o cadastro foi bem-sucedido, false caso contrário
     */
    public boolean cadastrar(String nome, String email, String senha) {
        // Verifica se já existe um usuário com o mesmo email
        if (usuarioRepository.buscarPorEmail(email) != null) {
            return false;
        }
        
        Usuario novoUsuario = new Usuario(nome, email);
        return usuarioRepository.adicionar(novoUsuario);
    }
    
    /**
     * Lista todos os usuários cadastrados.
     * 
     * @return Lista de usuários
     */
    public List<Usuario> listarTodos() {
        return usuarioRepository.listarTodos();
    }
}
