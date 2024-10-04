package com.example;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CalculadoraAbas extends JFrame {
    // atributos



    // construtor
    public CalculadoraAbas() {
        super("Calculadora Abas");
        // configurações basicas de calculadora
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);

        //adionar componentes de calculadora  
        JTabbedPane abas = new JTabbedPane();

        JPanel calcSimples = new CalculadoraSimples();
        abas.addTab("Simples", calcSimples);

        JPanel calcAvancada = new CalculadoraAvancada();
        abas.addTab("Avançada", calcAvancada);

        this.add(abas);
        
        this.setVisible(true);
    }
}
