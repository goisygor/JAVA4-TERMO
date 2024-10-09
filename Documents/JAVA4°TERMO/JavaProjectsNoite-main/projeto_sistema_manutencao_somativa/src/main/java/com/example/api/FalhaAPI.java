package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;
import com.example.models.Falha;
import com.example.models.Maquina; 
import java.util.ArrayList;
import java.util.List;

public class FalhaAPI {

    
    public static List<Falha> getFalhas() {
        String json = ApiConnection.getData("Falhas");
        List<Falha> falhas = new ArrayList<>();  

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            // Itera pelo array de falhas no JSON
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                // Criação de uma nova falha com base no JSON
                Falha falha = new Falha(
                    jsonObject.getString("id"),
                    jsonObject.getInt("maquinaID"),
                    jsonObject.getString("data"),
                    jsonObject.getString("problema"),
                    jsonObject.getString("prioridade"),
                    jsonObject.getString("operador")
                );
                
                // Adiciona a falha à lista de falhas
                falhas.add(falha);
            }
        }
        return falhas;  // Retorna a lista de falhas
    }
}
