package java_todo_list.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GerenciamentoTarefas extends JFrame {

    // Componentes da interface
    private JList<String> tarefasAFazerList;
    private JList<String> fazendoList;
    private JList<String> feitoList;
    private DefaultListModel<String> tarefasAFazerModel;
    private DefaultListModel<String> fazendoModel;
    private DefaultListModel<String> feitoModel;

    public GerenciamentoTarefas() {
        // Configurações da janela
        setTitle("Gerenciamento de Tarefas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializa os modelos de listas
        tarefasAFazerModel = new DefaultListModel<>();
        fazendoModel = new DefaultListModel<>();
        feitoModel = new DefaultListModel<>();

        // Criação das JLists
        tarefasAFazerList = new JList<>(tarefasAFazerModel);
        fazendoList = new JList<>(fazendoModel);
        feitoList = new JList<>(feitoModel);

        // Painel para os campos
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3)); // 3 colunas para cada categoria

        // Criação dos painéis para cada categoria
        JPanel panelAFazer = createCategoryPanel("Tarefas a Fazer", tarefasAFazerList);
        JPanel panelFazendo = createCategoryPanel("Fazendo", fazendoList);
        JPanel panelFeito = createCategoryPanel("Feito", feitoList);

        // Adicionando os painéis ao painel principal
        panel.add(panelAFazer);
        panel.add(panelFazendo);
        panel.add(panelFeito);

        // Painel para os botões de ação
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new GridLayout(4, 1)); // Botões em coluna

        // Botões de ação
        JButton moveToFazendoButton = new JButton("Mover para Fazendo");
        moveToFazendoButton.addActionListener(this::moveToFazendo);
        
        JButton moveToFeitoButton = new JButton("Mover para Feito");
        moveToFeitoButton.addActionListener(this::moveToFeito);

        JButton addTaskButton = new JButton("Adicionar Tarefa");
        addTaskButton.addActionListener(this::addTask);

        // Adiciona os botões ao painel de ações
        actionPanel.add(addTaskButton);
        actionPanel.add(moveToFazendoButton);
        actionPanel.add(moveToFeitoButton);

        // Adiciona o painel de ações à janela
        add(actionPanel, BorderLayout.EAST);

        // Adiciona o painel principal à janela
        add(panel, BorderLayout.CENTER);

        // Exemplo de como adicionar tarefas (simulação)
        tarefasAFazerModel.addElement("Estudar Java");
        tarefasAFazerModel.addElement("Revisar código");
        fazendoModel.addElement("Desenvolver interface");
        feitoModel.addElement("Testar funcionalidades");
    }

    // Método auxiliar para criar cada painel de categoria
    private JPanel createCategoryPanel(String title, JList<String> list) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));

        JScrollPane scrollPane = new JScrollPane(list);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    // Método para mover a tarefa para "Fazendo"
    private void moveToFazendo(ActionEvent e) {
        String selectedTask = tarefasAFazerList.getSelectedValue();
        if (selectedTask != null) {
            tarefasAFazerModel.removeElement(selectedTask);
            fazendoModel.addElement(selectedTask);
        }
    }

    // Método para mover a tarefa para "Feito"
    private void moveToFeito(ActionEvent e) {
        String selectedTask = fazendoList.getSelectedValue();
        if (selectedTask != null) {
            fazendoModel.removeElement(selectedTask);
            feitoModel.addElement(selectedTask);
        }
    }

    // Método para adicionar uma nova tarefa
    private void addTask(ActionEvent e) {
        String task = JOptionPane.showInputDialog(this, "Digite a nova tarefa:");
        if (task != null && !task.trim().isEmpty()) {
            tarefasAFazerModel.addElement(task);
        }
    }

    public static void main(String[] args) {
        // Exibe a interface gráfica
        SwingUtilities.invokeLater(() -> {
            new GerenciamentoTarefas().setVisible(true);
        });
    }
}
