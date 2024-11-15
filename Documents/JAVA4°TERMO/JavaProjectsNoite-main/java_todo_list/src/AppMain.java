package java_todo_list.src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppMain extends JFrame {
    public AppMain() {
        setTitle("Gerenciamento de Tarefas - To Do List");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configuração do menu principal
        JMenuBar menuBar = new JMenuBar();

        // Menu Cadastro
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem cadastroUsuarioItem = new JMenuItem("Cadastro de Usuários");
        JMenuItem cadastroTarefaItem = new JMenuItem("Cadastro de Tarefas");

        cadastroUsuarioItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastroUsuario(); // Abre a tela de cadastro de usuários
            }
        });

        cadastroTarefaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastroTarefa(); // Abre a tela de cadastro de tarefas
            }
        });

        menuCadastro.add(cadastroUsuarioItem);
        menuCadastro.add(cadastroTarefaItem);
        menuBar.add(menuCadastro);

        // Menu Gerenciamento
        JMenu menuGerenciamento = new JMenu("Gerenciamento");
        JMenuItem gerenciamentoTarefasItem = new JMenuItem("Gerenciamento de Tarefas");

        gerenciamentoTarefasItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GerenciamentoTarefas(); // Abre a tela de gerenciamento de tarefas
            }
        });

        menuGerenciamento.add(gerenciamentoTarefasItem);
        menuBar.add(menuGerenciamento);

        // Adiciona a barra de menus ao JFrame principal
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppMain app = new AppMain();
            app.setVisible(true);
        });
    }
}

