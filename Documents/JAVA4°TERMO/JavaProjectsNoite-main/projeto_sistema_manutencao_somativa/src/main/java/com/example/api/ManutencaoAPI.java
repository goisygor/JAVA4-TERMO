package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import com.example.models.Manutencao;


public class ManutencaoAPI {


    public static List<Manutencao> getmanutencoes() {
        String json = ApiConnection.getData("Manutencao");
        List<Manutencao> manutencoes = new ArrayList<>();


        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Manutencao manutencao = new Manutencao(
                    jsonObject.getString("id"),
                    jsonObject.getInt("maquinaID"),
                    jsonObject.getString("data"),
                    jsonObject.getString("tipo"),
                    jsonObject.getString("pecasTrocadas"),
                    jsonObject.getString("tempoDeParada"),
                    jsonObject.getString("tecnicoID"),
                    jsonObject.getString("obervacoes")
                );
                manutencoes.add(manutencao);
            }
        }
        return manutencoes;
    }
}



