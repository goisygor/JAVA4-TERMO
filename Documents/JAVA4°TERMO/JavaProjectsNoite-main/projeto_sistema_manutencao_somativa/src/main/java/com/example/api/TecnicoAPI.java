

package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;
import com.example.models.Tecnico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;



public class TecnicoAPI {

    public static List<Tecnico> getTecnicos() {
        String json = ApiConnection.getData("Tecnicos");
        List<Tecnico> tecnicos = new ArrayList<>();


        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Tecnico tecnico = new Tecnico(
                    jsonObject.getString("id"),
                    jsonObject.getString("nome"),
                    jsonObject.getString("especialidade"),
                    jsonObject.getString("disponibilidade")
                );
                tecnicos.add(tecnico);
            }
        }
        return tecnicos;
    }
}



