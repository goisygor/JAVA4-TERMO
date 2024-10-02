package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class UsuarioController {
    private List<Usuario> usuarios;
    private URL url;

    public UsuarioController() {
        usuarios = new ArrayList<>();
    }

    public void read() {
        try {
            URL url = new URL("http://localhost:3000/usuarios");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status != 200) { // diferente de 200 lançar uma exception
                throw new Exception("Erro de Conexão");
            }
            // gravar os dados na api na memoria
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String linha;
            // converter em um arquivo de texto
            StringBuffer content = new StringBuffer();
            while ((linha = br.readLine()) != null) {
                content.append(linha);
            }
            br.close(); // fecha a conexão
            // converter o arquivo de texto para dados da classe usuário
            JSONArray dadosUsuarios = new JSONArray(content.toString());

            for (int i = 0; i < dadosUsuarios.length(); i++) {
                JSONObject usuarioJson = dadosUsuarios.getJSONObject(i);
                usuarios.add(new Usuario(
                        usuarioJson.getString("id"),
                        usuarioJson.getString("nome"),
                        usuarioJson.getInt("idade"),
                        usuarioJson.getString("endereco")));
            }
            System.out.println(usuarios.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createUser(Usuario usuario) {
        // estabelecer conexão
        try {
            url = new URL("Http://localhost:3000/usuarios");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            // informações necessarias para o POST
            // criando um objeto Json
            JSONObject usuarioJson = new JSONObject();
            usuarioJson.put("nome", usuario.getNome());
            usuarioJson.put("idade", usuario.getIdade());
            usuarioJson.put("endereco", usuario.getEndereco());

            try (BufferedWriter bw = new BufferedWriter(
                 new OutputStreamWriter(con.getOutputStream(), "UTF-8"))) {
                bw.write(usuarioJson.toString());
                bw.flush();
            }            
                // verificar o status da resposta
                int status = con.getResponseCode();
                if (status != HttpURLConnection.HTTP_CREATED){
                    throw new Exception("Erro ao criar o usuário" +status);
                }
           
                System.out.println("Usuário criado com sucesso!");


        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}
