package com.example.climatemonitoring.view;

import java.util.Scanner;

import org.springframework.stereotype.Component;

/**
 * Classe utilitária para facilitar a interação com o terminal.
 * Segue o princípio SRP (Single Responsibility Principle) ao ter apenas a
 * responsabilidade
 * de gerenciar entrada e saída do terminal.
 */

@Component
public class TerminalUtil {
    private Scanner scanner;

    public TerminalUtil() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Exibe uma mensagem no terminal.
     * 
     * @param mensagem Mensagem a ser exibida
     */
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    /**
     * Lê uma string do terminal.
     * 
     * @param prompt Mensagem de solicitação
     * @return String lida
     */
    public String lerString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /**
     * Lê um número inteiro do terminal.
     * 
     * @param prompt Mensagem de solicitação
     * @return Número inteiro lido
     */
    public int lerInteiro(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }
    }

    /**
     * Lê um número decimal do terminal.
     * 
     * @param prompt Mensagem de solicitação
     * @return Número decimal lido
     */
    public double lerDecimal(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double valor = Double.parseDouble(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }
    }

    /**
     * Limpa a tela do terminal.
     */
    public void limparTela() {
        // Em sistemas Unix/Linux/Mac
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Em sistemas Windows (menos eficiente)
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /**
     * Pausa a execução até que o usuário pressione ENTER.
     */
    public void pausar() {
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }

    /**
     * Fecha o scanner.
     */
    public void fechar() {
        scanner.close();
    }
}
