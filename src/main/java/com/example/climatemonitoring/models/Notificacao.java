package com.example.climatemonitoring.models;

import java.time.LocalDateTime;

public class Notificacao {
    private String mensagem;
    private LocalDateTime dataHora;

    // Construtor padrão (obrigatório para Gson)
    public Notificacao() {
    }

    // Construtor com parâmetros
    public Notificacao(String mensagem, LocalDateTime dataHora) {
        this.mensagem = mensagem;
        this.dataHora = dataHora;
    }

    // Getters e Setters
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    // toString
    @Override
    public String toString() {
        return "Notificacao{" +
                "mensagem='" + mensagem + '\'' +
                ", dataHora=" + dataHora +
                '}';
    }
}
