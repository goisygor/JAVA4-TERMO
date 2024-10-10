package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import com.example.models.Falha;

public class FalhaAPI {


    public static List<Falha> getFalhas() {
        String json = ApiConnection.getData("Falhas");
        List<Falha> falhas = new ArrayList<>();


        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Falha falha = new Falha(
                    jsonObject.getString("id"),
                    (long) jsonObject.getInt("maquinaID"),
                    jsonObject.getString("data"),
                    jsonObject.getString("problema"),
                    jsonObject.getString("prioridade"),
                    jsonObject.getString("operador")
                );
                falhas.add(falha);
            }
        }
        return falhas;
    }
}



