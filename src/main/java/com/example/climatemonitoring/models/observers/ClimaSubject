package com.example.climatemonitoring.models.observers;

import java.util.ArrayList;
import java.util.List;

public class ClimaSubject implements Subject {
    private List<Observer> observers;

    public ClimaSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String mensagem) {
        for (Observer observer : observers) {
            observer.update(mensagem);
        }
    }
}