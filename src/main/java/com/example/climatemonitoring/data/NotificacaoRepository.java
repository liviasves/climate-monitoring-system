package com.example.climatemonitoring.data;

import com.example.climatemonitoring.models.Notificacao;
import com.example.climatemonitoring.utils.JsonUtil;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.gson.reflect.TypeToken;

/**
 * Repositório para persistência de notificações em arquivo JSON.
 * Segue o princípio SRP ao ter apenas a responsabilidade de gerenciar a
 * persistência de notificações.
 */
@Repository
public class NotificacaoRepository {
    private static final String ARQUIVO_NOTIFICACOES = "dados/notificacoes.json";
    private static final Type TIPO_LISTA = new TypeToken<List<Notificacao>>() {
    }.getType();

    /**
     * Construtor que garante a existência do diretório de dados.
     */
    public NotificacaoRepository() {
        File diretorio = new File("dados");
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }
    }

    /**
     * Lista todas as notificações.
     * 
     * @return Lista de notificações
     */
    public List<Notificacao> listarTodos() {
        try {
            File arquivo = new File(ARQUIVO_NOTIFICACOES);
            if (!arquivo.exists()) {
                return new ArrayList<>();
            }
            return JsonUtil.readJsonList(ARQUIVO_NOTIFICACOES, TIPO_LISTA);
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo de notificações: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Salva a lista de notificações no arquivo JSON.
     * 
     * @param notificacoes Lista de notificações a ser salva
     * @return true se a operação foi bem-sucedida, false caso contrário
     */
    public boolean salvarTodos(List<Notificacao> notificacoes) {
        try {
            JsonUtil.writeJsonList(ARQUIVO_NOTIFICACOES, notificacoes);
            return true;
        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo de notificações: " + e.getMessage());
            return false;
        }
    }

    /**
     * Adiciona uma nova notificação.
     * 
     * @param notificacao Notificação a ser adicionada
     * @return true se a operação foi bem-sucedida, false caso contrário
     */
    public boolean adicionar(Notificacao notificacao) {
        List<Notificacao> notificacoes = listarTodos();
        notificacoes.add(notificacao);
        return salvarTodos(notificacoes);
    }
}
