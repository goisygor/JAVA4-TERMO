package com.example;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimplesActionListener implements ActionListener{
    private Double valorAtual;
    JPanel calcSimples = new CalculadoraSimples();

    @Override
    public void actionPerformed(ActionEvent e) {
        String operador;
       String comando = e.getActionCommand();
       if (comando.matches("\\d")) {
        calcSimples.setDisplay((calcSimples.getDisplay()+ comando));
       }else if (comando.matches("[+\\-*/]")){
        valorAtual = Double.parseDouble(displaySimples.getText());
        operador = comando;
        displaySimples.setText("");
       }else if (comando.equals("="));
       switch (operador) {
        case "+":
            valorAtual+
            break;
       
        default:
            break;
       }
    }
    
}
