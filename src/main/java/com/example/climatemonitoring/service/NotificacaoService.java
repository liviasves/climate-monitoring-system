package com.example.climatemonitoring.service;

import com.example.climatemonitoring.data.NotificacaoRepository;
import com.example.climatemonitoring.models.Notificacao;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Serviço para gerenciamento de notificações.
 * Segue o princípio SRP ao ter apenas a responsabilidade de gerenciar
 * notificações.
 * Segue o princípio DIP ao depender de abstrações (repositório) injetadas via
 * construtor.
 */

@Service
public class NotificacaoService {
    private NotificacaoRepository notificacaoRepository;

    public NotificacaoService(NotificacaoRepository notificacaoRepository) {
        this.notificacaoRepository = notificacaoRepository;
    }

    /**
     * Registra uma nova notificação.
     * 
     * @param mensagem Mensagem da notificação
     * @return true se o registro foi bem-sucedido, false caso contrário
     */
    public boolean registrarNotificacao(String mensagem) {
        Notificacao notificacao = new Notificacao(mensagem);
        return notificacaoRepository.adicionar(notificacao);
    }

    /**
     * Lista todas as notificações registradas.
     * 
     * @return Lista de notificações
     */
    public List<Notificacao> listarHistorico() {
        return notificacaoRepository.listarTodos();
    }
}
