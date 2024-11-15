package com.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CadastroTarefa extends JFrame {
    private JComboBox<String> usuarioComboBox;
    private JTextField descricaoField, setorField;
    private JComboBox<String> prioridadeComboBox;
    private JButton cadastrarButton;

    public CadastroTarefa() {
        setTitle("Cadastro de Tarefas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Configurações de estilização e layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Campo Usuário
        JLabel usuarioLabel = new JLabel("Usuário:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(usuarioLabel, gbc);

        usuarioComboBox = new JComboBox<>();
        gbc.gridx = 1;
        add(usuarioComboBox, gbc);
        preencherUsuarios();

        // Campo Descrição
        JLabel descricaoLabel = new JLabel("Descrição:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(descricaoLabel, gbc);

        descricaoField = new JTextField(20);
        gbc.gridx = 1;
        add(descricaoField, gbc);

        // Campo Setor
        JLabel setorLabel = new JLabel("Setor:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(setorLabel, gbc);

        setorField = new JTextField(20);
        gbc.gridx = 1;
        add(setorField, gbc);

        // Campo Prioridade
        JLabel prioridadeLabel = new JLabel("Prioridade:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(prioridadeLabel, gbc);

        prioridadeComboBox = new JComboBox<>(new String[] {"baixa", "media", "alta"});
        gbc.gridx = 1;
        add(prioridadeComboBox, gbc);

        // Botão Cadastrar
        cadastrarButton = new JButton("Cadastrar Tarefa");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(cadastrarButton, gbc);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarTarefa();
            }
        });

        setVisible(true);
    }

    private void preencherUsuarios() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, nome FROM usuarios")) {
            while (rs.next()) {
                usuarioComboBox.addItem(rs.getString("id") + " - " + rs.getString("nome"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void cadastrarTarefa() {
        String usuarioSelecionado = (String) usuarioComboBox.getSelectedItem();
        if (usuarioSelecionado == null || usuarioSelecionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] usuarioInfo = usuarioSelecionado.split(" - ");
        int idUsuario = Integer.parseInt(usuarioInfo[0]);
        String descricao = descricaoField.getText();
        String setor = setorField.getText();
        String prioridade = (String) prioridadeComboBox.getSelectedItem();

        if (descricao.isEmpty() || setor.isEmpty() || prioridade == null) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO tarefas (id_usuario, descricao, setor, prioridade) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            stmt.setString(2, descricao);
            stmt.setString(3, setor);
            stmt.setString(4, prioridade);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Tarefa cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            // Limpa os campos após o cadastro
            descricaoField.setText("");
            setorField.setText("");
            prioridadeComboBox.setSelectedIndex(0);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar a tarefa.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
