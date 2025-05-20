package com.example.climatemonitoring.models.observers;

import com.example.climatemonitoring.models.Usuario;

public class UsuarioObserver implements Observer {
    private Usuario usuario;

    public UsuarioObserver(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void update(String mensagem) {
        System.out.println("Notificando usuário " + usuario.getNome() + " (" + usuario.getEmail() + "): " + mensagem);
    }
}