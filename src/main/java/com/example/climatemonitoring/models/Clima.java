package com.example.climatemonitoring.models;

public class Clima {
    private String localizacao;
    private Double temperatura;
    private Double umidade;
    private String condicoes;

    public Clima(String localizacao, Double temperatura, Double umidade, String condicoes) {
        this.localizacao = localizacao;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.condicoes = condicoes;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getUmidade() {
        return umidade;
    }

    public void setUmidade(Double umidade) {
        this.umidade = umidade;
    }

    public String getCondicoes() {
        return condicoes;
    }

    public void setCondicoes(String condicoes) {
        this.condicoes = condicoes;
    }

    @Override
    public String toString() {
        return "Clima{" +
                "localizacao='" + localizacao + '\'' +
                ", temperatura=" + temperatura +
                ", umidade=" + umidade +
                ", condicoes='" + condicoes + '\'' +
                '}';
    }
}