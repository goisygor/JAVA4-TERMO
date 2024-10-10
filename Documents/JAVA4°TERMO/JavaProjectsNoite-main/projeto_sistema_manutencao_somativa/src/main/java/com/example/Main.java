package com.example;

import javax.swing.SwingUtilities;

import com.example.View.SistemaManutencaoGUI;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new SistemaManutencaoGUI().setVisible(true);
    });
    }
}
