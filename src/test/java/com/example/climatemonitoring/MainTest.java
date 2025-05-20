package com.example.climatemonitoring;

import com.example.climatemonitoring.models.Clima;
import com.example.climatemonitoring.models.Usuario;
import com.example.climatemonitoring.models.observers.ClimaSubject;
import com.example.climatemonitoring.models.observers.UsuarioObserver;
import com.example.climatemonitoring.utils.JsonUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testObserverPattern() {
        // Create users and observers
        Usuario usuario1 = new Usuario("João", "joao@email.com", "123");
        Usuario usuario2 = new Usuario("Maria", "maria@email.com", "123");

        UsuarioObserver observer1 = new UsuarioObserver(usuario1);
        UsuarioObserver observer2 = new UsuarioObserver(usuario2);

        // Create the subject
        ClimaSubject climaSubject = new ClimaSubject();
        climaSubject.addObserver(observer1);
        climaSubject.addObserver(observer2);

        // Test notification
        climaSubject.notifyObservers("Alerta: Tempestade nas próximas 24h!");
        // No assertions needed here, just ensure no exceptions occur
    }

    @Test
    public void testJsonUtilForSingleObject() throws IOException {
        String filePath = "test_clima.json";

        // Create Clima object
        Clima clima = new Clima("Fazenda Boa Esperança", 28.5, 65.0, "Ensolarado");

        // Write to JSON
        JsonUtil.writeJson(filePath, clima);

        // Read from JSON
        Clima climaLido = JsonUtil.readJson(filePath, Clima.class);

        // Assertions
        assertEquals(clima.getLocalizacao(), climaLido.getLocalizacao());
        assertEquals(clima.getTemperatura(), climaLido.getTemperatura());
        assertEquals(clima.getUmidade(), climaLido.getUmidade());
        assertEquals(clima.getCondicoes(), climaLido.getCondicoes());

        // Clean up
        new File(filePath).delete();
    }

    @Test
    public void testJsonUtilForList() throws IOException {
        String filePath = "test_usuarios.json";

        // Create list of Usuario objects
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("João", "joao@email.com", "123"));
        usuarios.add(new Usuario("Maria", "maria@email.com", "123"));

        // Write to JSON
        JsonUtil.writeJsonList(filePath, usuarios);

        // Read from JSON
        Type usuarioListType = new TypeToken<List<Usuario>>() {}.getType();
        List<Usuario> usuariosLidos = JsonUtil.readJsonList(filePath, usuarioListType);

        // Assertions
        assertEquals(usuarios.size(), usuariosLidos.size());
        assertEquals(usuarios.get(0).getNome(), usuariosLidos.get(0).getNome());
        assertEquals(usuarios.get(1).getEmail(), usuariosLidos.get(1).getEmail());

        // Clean up
        new File(filePath).delete();
    }
}