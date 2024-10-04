package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produto> produtos;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private String nomeMaisCaro;
    private String nomeMaisBarato;
    private Double mediaPreco;

    public ProdutoController() {
        produtos = new ArrayList<>();
    }

    public void getConnection() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "postgres");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // listar produtos
    public void listarProdutos() {
        getConnection();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM produtos");
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"));
                produtos.add(produto);
            }
            System.out.println(produtos.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

    }

    public Double getMediaPreco() {
        // calcular média
        mediaPreco = (double) 0;
        for (Produto produto : produtos) {
            mediaPreco += produto.getPreco();
        }
        mediaPreco /= produtos.size();

        return mediaPreco;

    }

    public String getNomeMaisCaro() {
        // achar o mais caro
        double maiorPreco = 0;
        for (Produto produto : produtos) {
            if (maiorPreco <= produto.getPreco()) {
                maiorPreco = produto.getPreco();
                nomeMaisCaro = produto.getNome();
            }
        }

        return nomeMaisCaro;
    }

    public String getNomeMaisBarato() {
        // achar o mais barato
        double menorPreco = Double.MAX_VALUE;
        for (Produto produto : produtos) {
            if (menorPreco <= produto.getPreco()) {
                menorPreco = produto.getPreco();
                nomeMaisBarato = produto.getNome();
            }
        }
        return nomeMaisBarato;
    }
}
