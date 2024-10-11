package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.TecnicoAPI;
import com.example.models.Tecnico;

public class TecnicoController {
    private List<Tecnico> tecnicos;

    public TecnicoController() {
        tecnicos = new ArrayList<>();
    }

    // Métodos - CRUD

    public void createTecnico(Tecnico tecnico) {
        this.tecnicos.add(tecnico);
    }

    public List<Tecnico> readTecnicos() {
        tecnicos = TecnicoAPI.getTecnicos();
        return tecnicos;
    }

    // UPDATE (Atualiza um técnico pelo índice)
    public void updateTecnico(int posicao, Tecnico tecnico) {
        if (posicao >= 0 && posicao < tecnicos.size()) {
            tecnicos.set(posicao, tecnico);
        }
    }

    // DELETE (Remove um técnico pelo índice)
    public void deleteTecnico(int posicao) {
        if (posicao >= 0 && posicao < tecnicos.size()) {
            tecnicos.remove(posicao);
        }
    }
}
