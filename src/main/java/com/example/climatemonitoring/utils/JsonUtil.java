package com.example.climatemonitoring.utils;

import com.example.climatemonitoring.models.Notificacao;
import com.example.climatemonitoring.models.Usuario;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

public class JsonUtil {

    private static final String CAMINHO_USUARIOS = "dados/usuarios.json";
    private static final String CAMINHO_NOTIFICACOES = "dados/notificacoes.json";

    // Gson configurado para lidar com LocalDateTime
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (src, typeOfSrc, context) ->
                    new JsonPrimitive(src.toString()))
            .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) ->
                    LocalDateTime.parse(json.getAsString()))
            .setPrettyPrinting()
            .create();

    private JsonUtil() {
    }

    // ----- Métodos genéricos -----
    public static <T> void salvarListaComoJson(String caminho, List<T> lista) {
        try (Writer writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> lerJsonParaLista(String caminho, Class<T> classe) {
        List<T> lista = null;
        try (Reader reader = new FileReader(caminho)) {
            Type type = TypeToken.getParameterized(List.class, classe).getType();
            lista = gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista != null ? lista : List.of();
    }

    // ----- Métodos específicos usados na classe principal -----
    public static void salvarUsuarios(List<Usuario> usuarios) {
        salvarListaComoJson(CAMINHO_USUARIOS, usuarios);
    }

    public static List<Usuario> lerUsuarios() {
        return lerJsonParaLista(CAMINHO_USUARIOS, Usuario.class);
    }

    public static void salvarNotificacoes(List<Notificacao> notificacoes) {
        salvarListaComoJson(CAMINHO_NOTIFICACOES, notificacoes);
    }

    public static List<Notificacao> lerNotificacoes() {
        return lerJsonParaLista(CAMINHO_NOTIFICACOES, Notificacao.class);
    }
}
