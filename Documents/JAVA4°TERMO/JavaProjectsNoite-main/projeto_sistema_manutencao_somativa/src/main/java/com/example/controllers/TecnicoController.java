package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.MaquinaAPI;
import com.example.api.TecnicoAPI;
import com.example.models.Tecnico;

public class TecnicoController {
    private List<Tecnico> tecnicos;

    public TecnicoController() {
        tecnicos = new ArrayList<>();
    }

    // métodos - CRUD

    public void createTecnico(Tecnico tecnico) {
        this.tecnicos.add(tecnico);
    }

    public List<Tecnico> readTecnicos() {
        tecnicos = TecnicoAPI.getTecnicos();
        return tecnicos;
    }
    // UPDATE (Atualiza uma máquina pelo id)
   public void updateTecnico(int posicao, Tecnico tecnico){
    tecnicos.set(posicao, tecnico);
   }

    // DELETE (Remove uma máquina pelo id)
    public void deleteTecnico(int posicao) {
        tecnicos.remove(posicao);
    }
}
