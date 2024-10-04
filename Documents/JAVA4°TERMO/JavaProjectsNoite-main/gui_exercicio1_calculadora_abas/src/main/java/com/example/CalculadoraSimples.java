package com.example;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;;

public class CalculadoraSimples extends JPanel {
    JTextField displaySimples;
    String[] botoes = { "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "=", "+", "C" };

    // CONSTRUTOR
    public CalculadoraSimples() {
        super(new BorderLayout());
        displaySimples = new JTextField();
        displaySimples.setHorizontalAlignment(JTextField.RIGHT);
        displaySimples.setEditable(false);
        this.add(displaySimples, BorderLayout.NORTH);

        // CRIAR UM PAINEL PARA OS BOTÕES
        JPanel painelBotoes = new JPanel(new GridLayout(4, 4, 2, 2));
        for (String textBotoes : botoes) {
            JButton botao = new JButton(textBotoes);
            // adicionar ação dos botões 
            painelBotoes.add(botao);
        }
        this.add(painelBotoes, BorderLayout.CENTER);
    }
    public void setDisplaySimples(String texto){
        this.displaySimples.setText(texto);
    }
    public String getDisplaySimples(){
        return this.displaySimples.getText();
    }
}
