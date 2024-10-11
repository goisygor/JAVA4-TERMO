package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import com.example.models.Falha;

public class FalhaAPI {

    public static List<Falha> getFalhas() {
        String json = ApiConnection.getData("falhas");
        List<Falha> falhas = new ArrayList<>();

        if (json != null && !json.isEmpty()) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                
                // Verificações de tipo para garantir dados válidos
                String id = jsonObject.optString("id", "");
                long maquinaID = jsonObject.optLong("maquinaID", 0);
                LocalDate data = LocalDate.parse(jsonObject.optString("data", LocalDate.now().toString()));
                String problema = jsonObject.optString("problema", "Desconhecido");
                String prioridade = jsonObject.optString("prioridade", "Normal");
                String operador = jsonObject.optString("operador", "N/A");

                // Criação do objeto Falha
                Falha falha = new Falha(id, maquinaID, data, problema, prioridade, operador);
                falhas.add(falha);
            }
        }
        return falhas;
    }
}
