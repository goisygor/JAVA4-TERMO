package com.example.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import com.example.models.Manutencao;

public class ManutencaoAPI {
    public static List<Manutencao> getManutencaos() {
        String json = ApiConnection.getData("historicoManutencao");
        List<Manutencao> manutencaos = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                
                // Verificação de campos
                String id = jsonObject.optString("id", "");
                long maquinaId = jsonObject.optLong("maquinaId", 0);
                LocalDate data = LocalDate.parse(jsonObject.optString("data", LocalDate.now().toString()));
                String tipo = jsonObject.optString("tipo", "");
                String pecasTrocadas = jsonObject.optString("pecasTrocadas", "");
                long tempoDeParada = jsonObject.optLong("tempoDeParada", 0);
                String tecnicoId = jsonObject.optString("tecnicoId", "");
                String observacoes = jsonObject.optString("observacoes", "");

                Manutencao manutencao = new Manutencao(id, maquinaId, data, tipo, pecasTrocadas, tempoDeParada, tecnicoId, observacoes);
                manutencaos.add(manutencao);
            }
        }
        return manutencaos;
    }
}
