package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProdutosDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgresql";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        try {
            // Conecta ao banco de dados
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");

            String query = "SELECT nome, preco FROM produtos";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            double total = 0;
            double maxPrice = Double.MIN_VALUE;
            double minPrice = Double.MAX_VALUE;
            String mostExpensiveProduct = "";
            String cheapestProduct = "";
            int count = 0;

            System.out.println("Produtos disponíveis:");

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                double preco = resultSet.getDouble("preco");

                System.out.printf("Nome: %s, Preço: %.2f%n", nome, preco);

                // Cálculo de média, mínimo e máximo
                total += preco;
                count++;

                if (preco > maxPrice) {
                    maxPrice = preco;
                    mostExpensiveProduct = nome;
                }

                if (preco < minPrice) {
                    minPrice = preco;
                    cheapestProduct = nome;
                }
            }

            // Calcular e exibir a média de preços
            if (count > 0) {
                double averagePrice = total / count;
                System.out.printf("Produto mais caro: %s (%.2f)%n", mostExpensiveProduct, maxPrice);
                System.out.printf("Produto mais barato: %s (%.2f)%n", cheapestProduct, minPrice);
                System.out.printf("Média de preços: %.2f%n", averagePrice);
            } else {
                System.out.println("Nenhum produto encontrado.");
            }

            // Fechar a conexão
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


