package com.example.climatemonitoring.service;

import org.springframework.stereotype.Service;

import com.example.climatemonitoring.api.ClimaAPI;
import com.example.climatemonitoring.models.Clima;
import com.example.climatemonitoring.models.observers.ClimaSubject;
import com.example.climatemonitoring.models.observers.Observer;

/**
 * Serviço para gerenciamento de dados climáticos.
 * Segue o princípio SRP ao ter apenas a responsabilidade de gerenciar dados
 * climáticos.
 * Segue o princípio DIP ao depender de abstrações (API) injetadas via
 * construtor.
 */
@Service
public class ClimaService {
    private ClimaAPI climaAPI;
    private ClimaSubject climaSubject;

    public ClimaService(ClimaAPI climaAPI) {
        this.climaAPI = climaAPI;
        this.climaSubject = new ClimaSubject();
    }

    /**
     * Obtém os dados climáticos atuais para uma localização.
     * 
     * @param localizacao Nome da localização
     * @return Objeto Clima com os dados atuais
     */
    public Clima obterDadosClimaticos(String localizacao) {
        return climaAPI.obterDadosClimaticos(localizacao);
    }

    /**
     * Obtém a análise de risco para plantio nos próximos dias.
     * 
     * @param localizacao Nome da localização
     * @return Array de strings com a análise para cada dia
     */
    public String[] obterAnaliseRisco(String localizacao) {
        return climaAPI.obterAnaliseRisco(localizacao);
    }

    /**
     * Adiciona um observador para receber notificações climáticas.
     * 
     * @param observer Observador a ser adicionado
     */
    public void adicionarObservador(Observer observer) {
        climaSubject.addObserver(observer);
    }

    /**
     * Remove um observador.
     * 
     * @param observer Observador a ser removido
     */
    public void removerObservador(Observer observer) {
        climaSubject.removeObserver(observer);
    }

    /**
     * Notifica todos os observadores com uma mensagem.
     * 
     * @param mensagem Mensagem a ser enviada
     */
    public void notificarObservadores(String mensagem) {
        climaSubject.notifyObservers(mensagem);
    }

    /**
     * Gera um boletim climático formatado.
     * 
     * @param localizacao Nome da localização
     * @return String formatada com o boletim climático
     */
    public String gerarBoletimClimatico(String localizacao) {
        Clima clima = obterDadosClimaticos(localizacao);

        // Simulação de data e hora
        String dataHora = "20/05/2025 14:47";

        // Simulação de sensação térmica (temperatura + fator aleatório)
        double sensacaoTermica = clima.getTemperatura() + (Math.random() * 5 - 2);

        // Simulação de velocidade do vento
        double velocidadeVento = 5 + Math.random() * 15;

        // Simulação de previsão de chuva
        double previsaoChuva = Math.random() * 5;

        StringBuilder boletim = new StringBuilder();
        boletim.append("Boletim Atual – ").append(localizacao).append("\n");
        boletim.append("Data: ").append(dataHora).append("\n");
        boletim.append(String.format("Temperatura: %.1fºC | Sensação: %.1fºC\n",
                clima.getTemperatura(), sensacaoTermica));
        boletim.append(String.format("Umidade: %.0f%% | Vento: %.1f km/h\n",
                clima.getUmidade(), velocidadeVento));
        boletim.append(String.format("Céu: %s | Previsão de chuva: %.1f mm",
                clima.getCondicoes(), previsaoChuva));

        return boletim.toString();
    }
}
