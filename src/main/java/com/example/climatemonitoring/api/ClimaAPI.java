package com.example.climatemonitoring.api;

import com.example.climatemonitoring.models.Clima;

import java.util.Random;

import org.springframework.stereotype.Service;

/**
 * API para obtenção de dados climáticos.
 * Simulação de uma API real para fins de demonstração.
 * Segue o princípio SRP ao ter apenas a responsabilidade de obter dados
 * climáticos.
 */
@Service
public class ClimaAPI {
    private Random random;

    public ClimaAPI() {
        this.random = new Random();
    }

    /**
     * Obtém os dados climáticos atuais para uma localização.
     * 
     * @param localizacao Nome da localização
     * @return Objeto Clima com os dados atuais
     */
    public Clima obterDadosClimaticos(String localizacao) {
        // Simulação de dados climáticos
        double temperatura = 20 + random.nextDouble() * 15; // Entre 20 e 35 graus
        double umidade = 40 + random.nextDouble() * 50; // Entre 40% e 90%

        String[] condicoes = { "Ensolarado", "Parcialmente nublado", "Nublado", "Chuvoso", "Tempestade" };
        String condicao = condicoes[random.nextInt(condicoes.length)];

        return new Clima(localizacao, temperatura, umidade, condicao);
    }

    /**
     * Obtém a análise de risco para plantio nos próximos dias.
     * 
     * @param localizacao Nome da localização
     * @return Array de strings com a análise para cada dia
     */
    public String[] obterAnaliseRisco(String localizacao) {
        String[] analise = new String[3];

        for (int i = 0; i < 3; i++) {
            double temperatura = 20 + random.nextDouble() * 20; // Entre 20 e 40 graus
            double precipitacao = random.nextDouble() * 15; // Entre 0 e 15 mm

            String risco;
            if (temperatura > 35 || precipitacao > 10) {
                risco = "Desfavorável";
            } else if (temperatura > 30 || precipitacao < 0.5) {
                risco = "Atenção";
            } else {
                risco = "Favorável";
            }

            analise[i] = String.format("Dia %d: %.1fºC / %.1f mm – %s",
                    i + 1, temperatura, precipitacao, risco);
        }

        return analise;
    }
}
