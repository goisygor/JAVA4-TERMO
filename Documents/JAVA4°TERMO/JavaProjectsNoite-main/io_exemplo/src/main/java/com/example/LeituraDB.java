package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LeituraDB {
    public void exemplo() {
        try {
            // estabele conexão
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "postgres");
                    //tratudor de sql
                    Statement stmt = con.createStatement();
                    //armazenar os resultados
                    ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");

                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("id")
                        +"NOME:" + rs.getInt("nome")
                        +"IDADE: " + rs.getInt("idade"));
                    }
                    con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
