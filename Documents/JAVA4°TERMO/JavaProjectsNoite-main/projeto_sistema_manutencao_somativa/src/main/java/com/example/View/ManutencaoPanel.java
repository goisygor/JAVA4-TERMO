package com.example.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.example.controllers.ManutencaoController;
import com.example.models.Manutencao;

public class ManutencaoPanel extends JPanel {
    // Atributos
    private ManutencaoController manutencaoController;
    private JTable manutencaoTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarManutencao;

    // Construtor
    public ManutencaoPanel() {
        super(new BorderLayout());
        manutencaoController = new ManutencaoController();

        // Definir o modelo de tabela com as colunas
        tableModel = new DefaultTableModel(new Object[]{
            "ID", "ID Maquina", "Data", "Tipo", "Peças Trocadas", "Tecnico", "Observações",
        }, 0);
        
        // Criar a JTable com o modelo
        manutencaoTable = new JTable(tableModel);

        // Preencher a tabela com os dados da API
        List<Manutencao> manuts = manutencaoController.readManutencoes();
        if (manuts != null && !manuts.isEmpty()) {
            for (Manutencao manut : manuts) {
                tableModel.addRow(new Object[]{
                    manut.getId(),
                    manut.getMaquinaID(),
                    manut.getData(),
                    manut.getTipo(),
                    manut.getPecasTrocadas(),
                    manut.getTecnicoID(),
                    manut.getObservacoes(),
                });
            }
            // Notificar que os dados foram atualizados
            tableModel.fireTableDataChanged();
        } else {
            System.out.println("Nenhuma manutenção encontrada.");
        }

        // Adicionar a tabela dentro de um JScrollPane para rolagem
        JScrollPane scrollPane = new JScrollPane(manutencaoTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarManutencao = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar Alterações");
        painelInferior.add(btnCadastrarManutencao);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);
    }
}
