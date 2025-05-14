package com.example.climatemonitoring.models;

public class Usuario {
    private String nome;
    private String email;

    // Construtor padrão (obrigatório para Gson)
    public Usuario() {
    }

    // Construtor com parâmetros
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString
    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
