package com.example.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.example.controllers.TecnicoController;
import com.example.models.Tecnico;

public class TecnicosPanel extends JPanel {
    // Atributos
    private TecnicoController tecnicoController;
    private JTable tecnicosTable;
    private DefaultTableModel tableModel;
    private JButton btnCadastrarTecnico;
    private JButton btnSalvarAlteracoes;

    // Construtor
    public TecnicosPanel() {
        // Configurar o layout principal do JPanel
        super(new BorderLayout());
        tecnicoController = new TecnicoController();

        // Criar modelo de tabela com os nomes das colunas
        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Nome", "Especialidade", "Disponibilidade"
        }, 0);

        // Criar tabela com o modelo
        tecnicosTable = new JTable(tableModel);

        // Popular a tabela com os dados dos técnicos
        List<Tecnico> tecnicos = tecnicoController.readTecnicos();
        if (tecnicos != null && !tecnicos.isEmpty()) {
            for (Tecnico tecnico : tecnicos) {
                tableModel.addRow(new Object[]{
                    tecnico.getId(),
                    tecnico.getNome(),
                    tecnico.getEspecialidade(),
                    tecnico.getDisponibilidade()
                });
            }
            // Notificar que os dados foram atualizados
            tableModel.fireTableDataChanged();
        } else {
            System.out.println("Nenhum técnico encontrado.");
        }

        // Adicionar a tabela dentro de um JScrollPane para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(tecnicosTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Criar painel inferior para os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarTecnico = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar Alterações");
        painelInferior.add(btnCadastrarTecnico);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);
    }
}
