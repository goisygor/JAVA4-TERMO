package java_todo_list.src;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroUsuario extends JFrame {
    private JTextField nomeField, emailField;
    private JButton cadastrarButton;

    public CadastroUsuario() {
        setTitle("Cadastro de Usuário");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campo Nome
        JLabel nomeLabel = new JLabel("Nome:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nomeLabel, gbc);

        nomeField = new JTextField(20);
        gbc.gridx = 1;
        add(nomeField, gbc);

        // Campo Email
        JLabel emailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(emailLabel, gbc);

        emailField = new JTextField(20);
        gbc.gridx = 1;
        add(emailField, gbc);

        // Botão Cadastrar
        cadastrarButton = new JButton("Cadastrar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(cadastrarButton, gbc);

        cadastrarButton.addActionListener(e -> cadastrarUsuario());

        setVisible(true);
    }

    private void cadastrarUsuario() {
        String nome = nomeField.getText().trim();
        String email = emailField.getText().trim();

        // Verificação de campos
        if (nome.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificação básica de email
        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Email inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Verifica se a conexão foi estabelecida
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Falha ao conectar ao banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, email);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                nomeField.setText("");
                emailField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum usuário foi cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
