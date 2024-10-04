package com.example;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class CalculadoraAvancada extends JPanel {
    JTextField displayAvancada;
    String[] botoes = { "^", "sqrt", "log", "!",
                        "7", "8", "9", "/",
                        "4", "5", "6", "*",
                         "1", "2", "3", "-",
                         "0", "=", "+", "C",
    };

    // CONSTRUTOR
    public CalculadoraAvancada() {
        super(new BorderLayout());
        displayAvancada = new JTextField();
        displayAvancada.setHorizontalAlignment(JTextField.RIGHT);
        displayAvancada.setEditable(false);
        this.add(displayAvancada, BorderLayout.NORTH);

        // CRIAR UM PAINEL PARA OS BOTÕES
        JPanel painelBotoes = new JPanel(new GridLayout(5, 4, 2, 2));
        for (String textBotoes : botoes) {
            JButton botao = new JButton(textBotoes);
            painelBotoes.add(botao);
        }
        this.add(painelBotoes, BorderLayout.CENTER);
    }
}
