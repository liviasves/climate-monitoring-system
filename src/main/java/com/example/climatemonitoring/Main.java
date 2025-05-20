package com.example.climatemonitoring;

import com.example.climatemonitoring.api.ClimaAPI;
import com.example.climatemonitoring.data.NotificacaoRepository;
import com.example.climatemonitoring.data.UsuarioRepository;
import com.example.climatemonitoring.service.ClimaService;
import com.example.climatemonitoring.service.NotificacaoService;
import com.example.climatemonitoring.service.UsuarioService;
import com.example.climatemonitoring.view.MenuPrincipal;
import com.example.climatemonitoring.view.MenuUsuario;
import com.example.climatemonitoring.view.TerminalUtil;


public class Main {
    public static void main(String[] args) {
        // Inicializa os repositórios
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        NotificacaoRepository notificacaoRepository = new NotificacaoRepository();
        
        // Inicializa a API de clima
        ClimaAPI climaAPI = new ClimaAPI();
        
        // Inicializa os serviços
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        ClimaService climaService = new ClimaService(climaAPI);
        NotificacaoService notificacaoService = new NotificacaoService(notificacaoRepository);
        
        // Inicializa os utilitários de terminal
        TerminalUtil terminal = new TerminalUtil();
        
        // Inicializa os menus
        MenuUsuario menuUsuario = new MenuUsuario(terminal, climaService, notificacaoService);
        MenuPrincipal menuPrincipal = new MenuPrincipal(terminal, usuarioService, menuUsuario);
        
        try {
            // Exibe o menu principal
            menuPrincipal.exibir();
        } finally {
            // Fecha o scanner ao finalizar
            terminal.fechar();
        }
    }
}
