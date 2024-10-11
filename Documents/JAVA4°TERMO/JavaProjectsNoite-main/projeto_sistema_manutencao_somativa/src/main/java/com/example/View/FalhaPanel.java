package com.example.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.example.controllers.FalhaController;
import com.example.models.Falha;

public class FalhaPanel extends JPanel {
    // Atributos
    private FalhaController falhaController;
    private JTable falhasTable;
    private DefaultTableModel tableModel;
    private JButton btnCadastrarFalha;
    private JButton btnSalvarAlteracoes;

    // Construtor
    public FalhaPanel() {
        // Configurar o layout principal do JPanel
        super(new BorderLayout());
        falhaController = new FalhaController();

        // Criar modelo de tabela com os nomes das colunas
        tableModel = new DefaultTableModel(new Object[] {
                "ID", "Maquina ID", "Data", "Problema", "Prioridade", "Operador",
        }, 0);

        // Criar tabela com o modelo
        falhasTable = new JTable(tableModel);

        // Popular a tabela com os dados das falhas
        List<Falha> falhas = falhaController.readFalhas();
        if (falhas != null && !falhas.isEmpty()) {
            for (Falha falha : falhas) {
                tableModel.addRow(new Object[] {
                        falha.getId(),
                        falha.getMaquinaID(),
                        falha.getData(),
                        falha.getProblema(),
                        falha.getPrioridade(),
                        falha.getOperador(),
                });
            }
            // Notificar que os dados foram atualizados
            tableModel.fireTableDataChanged();
        } else {
            System.out.println("Nenhuma falha encontrada.");
        }

        // Adicionar a tabela dentro de um JScrollPane para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(falhasTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Criar painel inferior para os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarFalha = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarFalha);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);
    }
}
