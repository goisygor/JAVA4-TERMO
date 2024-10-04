package com.example;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import javax.swing.JButton;

import java.awt.event.ActionListener;

public class minhaJanela extends JFrame {
    public minhaJanela() {
        super("Minha Janela");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 300);

        // criando um painel ( Container Generico)
        JPanel painel = new JPanel();
        this.add(painel);

        // adicionando um botão
        JButton botao = new JButton("Clique Aqui");
        painel.add(botao);

        // adicionar um evento no botao
        botao.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    null, "Botão Clicado");
        });

    }
}
