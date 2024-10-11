package com.example.controllers;

import java.util.List;
import com.example.api.FalhaAPI;
import com.example.models.Falha;

public class FalhaController {
    private List<Falha> falhas;

    public FalhaController() {
        falhas = FalhaAPI.getFalhas(); // Inicializa a lista ao criar o controlador
    }

    // CRUD - Create, Read, Update
    public void createFalha(Falha falha) {
        falhas.add(falha);
    }

    public List<Falha> readFalhas() {
        return falhas;
    }

    public void updateFalha(int posicao, Falha falha) {
        falhas.set(posicao, falha);
    }
}
