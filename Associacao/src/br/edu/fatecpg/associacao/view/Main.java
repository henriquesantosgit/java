package br.edu.fatecpg.associacao.view;



import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import br.edu.fatecpg.associacao.model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Empresa empresa;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Main() {
        empresa = new Empresa(); // Instancia a empresa para gerenciar clientes e funcionários

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridLayout(0, 1, 10, 10));
        setContentPane(contentPane);

        // Botão para adicionar Cliente
        JButton btnAddCliente = new JButton("Adicionar Cliente");
        btnAddCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
                String email = JOptionPane.showInputDialog("Digite o email do cliente:");
                empresa.adicionarCliente(nome, email);
                JOptionPane.showMessageDialog(null, "Cliente adicionado!");
            }
        });
        contentPane.add(btnAddCliente);

        // Botão para exibir Clientes
        JButton btnExibirClientes = new JButton("Exibir Clientes");
        btnExibirClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                empresa.exibirClientes();
            }
        });
        contentPane.add(btnExibirClientes);

        // Botão para adicionar Funcionário
        JButton btnAddFuncionario = new JButton("Adicionar Funcionário");
        btnAddFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Digite o nome do funcionário:");
                String cargo = JOptionPane.showInputDialog("Digite o cargo do funcionário:");
                double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do funcionário:"));
                empresa.adicionarFuncionario(nome, cargo, salario);
                JOptionPane.showMessageDialog(null, "Funcionário adicionado!");
            }
        });
        contentPane.add(btnAddFuncionario);

        // Botão para exibir Funcionários
        JButton btnExibirFuncionarios = new JButton("Exibir Funcionários");
        btnExibirFuncionarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                empresa.exibirFuncionarios();
            }
        });
        contentPane.add(btnExibirFuncionarios);

        // Botão para calcular e exibir Folha Salarial
        JButton btnCalcularFolha = new JButton("Calcular Folha Salarial");
        btnCalcularFolha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double totalFolha = empresa.calcularFolhaSalarial();
                JOptionPane.showMessageDialog(null, "Folha Salarial Total: R$ " + totalFolha);
            }
        });
        contentPane.add(btnCalcularFolha);

        // Botão para calcular e exibir Média Salarial
        JButton btnCalcularMediaSalarial = new JButton("Calcular Média Salarial");
        btnCalcularMediaSalarial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double mediaSalarial = empresa.calcularMediaSalarial();
                JOptionPane.showMessageDialog(null, "Média Salarial: R$ " + mediaSalarial);
            }
        });
        contentPane.add(btnCalcularMediaSalarial);
    }
}

