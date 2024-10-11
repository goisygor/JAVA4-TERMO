package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;
import com.example.models.Maquina;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class MaquinaAPI {


    public static List<Maquina> getMaquinas() {
        String json = ApiConnection.getData("maquinas");
        List<Maquina> maquinas = new ArrayList<>();


        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Maquina maquina = new Maquina(
                    jsonObject.getString("id"),
                    jsonObject.getString("codigo"),
                    jsonObject.getString("nome"),
                    jsonObject.getString("modelo"),
                    jsonObject.getString("fabricante"),
                    LocalDate.parse(jsonObject.getString("dataAquisicao")),
                    jsonObject.getInt("tempoVidaEstimado"),
                    jsonObject.getString("localizacao"),
                    jsonObject.getString("detalhes"),
                    jsonObject.getString("manual")
                );
                maquinas.add(maquina);
            }
        }
        return maquinas;
    }

    public static void postMaquinas (Maquina maquina){
        // criar um objeto Json
        JSONObject maquinaObjectc = new JSONObject();
        maquinaObjectc.put("id", maquina.getId()); 
        maquinaObjectc.put("codigo", maquina.getCodigo());
        maquinaObjectc.put("nome", maquina.getNome());
        maquinaObjectc.put("modelo", maquina.getModelo());
        maquinaObjectc.put("fabricante", maquina.getFabricante());
        maquinaObjectc.put("dataAquisicao", maquina.getDataAquisicao());
        maquinaObjectc.put("tempoVidaEstimado", maquina.getTempoVidaEstimado());
        maquinaObjectc.put("localizacao", maquina.getLocalizacao());
        maquinaObjectc.put("detalhes", maquina.getDetalhes());
        maquinaObjectc.put("manual", maquina.getManual());

       if (maquinaObjectc.isEmpty()) {
        ApiConnection.postData("maquinas", maquinaObjectc.toString());
       }
        

        

    }
}



