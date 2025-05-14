package com.example.climatemonitoring;

import com.example.climatemonitoring.models.Usuario;
import com.example.climatemonitoring.models.Notificacao;
import com.example.climatemonitoring.utils.JsonUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ClimatemonitoringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClimatemonitoringApplication.class, args);
	}

@Override
public void run(String... args) {
    // Criar dados simulados
    Usuario u1 = new Usuario("João", "joao@email.com");
    Usuario u2 = new Usuario("Maria", "maria@email.com");
    List<Usuario> usuarios = Arrays.asList(u1, u2);

    Notificacao n1 = new Notificacao("Alerta de calor", LocalDateTime.now());
    Notificacao n2 = new Notificacao("Chuva prevista amanhã", LocalDateTime.now().plusDays(1));
    List<Notificacao> notificacoes = Arrays.asList(n1, n2);

    JsonUtil.salvarUsuarios(usuarios);
    JsonUtil.salvarNotificacoes(notificacoes);

    List<Usuario> usuariosLidos = JsonUtil.lerUsuarios();
    List<Notificacao> notificacoesLidas = JsonUtil.lerNotificacoes();

    System.out.println("Usuários lidos do JSON:");
    usuariosLidos.forEach(System.out::println);

    System.out.println("Notificações lidas do JSON:");
    notificacoesLidas.forEach(System.out::println);
}

	}

