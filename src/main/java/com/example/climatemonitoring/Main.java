package com.example.climatemonitoring;

import com.example.climatemonitoring.view.MenuPrincipal;
import com.example.climatemonitoring.view.TerminalUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner run(MenuPrincipal menuPrincipal, TerminalUtil terminal) {
        return args -> {
            try {
                menuPrincipal.exibir();
            } finally {
                terminal.fechar();
            }
        };
    }
}
