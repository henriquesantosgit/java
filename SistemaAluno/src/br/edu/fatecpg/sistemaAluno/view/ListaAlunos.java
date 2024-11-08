package br.edu.fatecpg.sistemaAluno.view;

import br.edu.fatecpg.sistemaAluno.model.Aluno;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;

public class ListaAlunos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<Aluno> comboBoxAlunos;
    private JTextField nomeField;
    private JTextField telefoneField;
    private JButton btnAtualizar;
    private JButton btnExcluir;
    private ArrayList<Aluno> listaAlunos;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ListaAlunos frame = new ListaAlunos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

  
    public ListaAlunos() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        listaAlunos = new ArrayList<>(); 

    
        comboBoxAlunos = new JComboBox<>();
        comboBoxAlunos.setBounds(30, 30, 200, 25);
        contentPane.add(comboBoxAlunos);
        comboBoxAlunos.addActionListener(e -> preencherCampos());

       
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 70, 50, 25);
        contentPane.add(lblNome);
        nomeField = new JTextField();
        nomeField.setBounds(90, 70, 200, 25);
        contentPane.add(nomeField);

     
        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(30, 110, 60, 25);
        contentPane.add(lblTelefone);
        telefoneField = new JTextField();
        telefoneField.setBounds(90, 110, 200, 25);
        contentPane.add(telefoneField);

   
        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(30, 150, 100, 25);
        contentPane.add(btnAtualizar);
        btnAtualizar.addActionListener(e -> atualizarAluno());
        btnAtualizar.setEnabled(false); 

       
        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(150, 150, 100, 25);
        contentPane.add(btnExcluir);
        btnExcluir.addActionListener(e -> excluirAluno());
        btnExcluir.setEnabled(false); 

        carregarAlunos(); 
    }

  
    private void carregarAlunos() {
        listaAlunos.add(new Aluno("Ana", "123456789"));
        listaAlunos.add(new Aluno("Carlos", "987654321"));
        atualizarComboBox();
    }

    private void atualizarComboBox() {
        comboBoxAlunos.removeAllItems();
        for (Aluno aluno : listaAlunos) {
            comboBoxAlunos.addItem(aluno);
        }
    }

   
    private void preencherCampos() {
        Aluno alunoSelecionado = (Aluno) comboBoxAlunos.getSelectedItem();
        if (alunoSelecionado != null) {
            nomeField.setText(alunoSelecionado.getNome());
            telefoneField.setText(alunoSelecionado.getTelefone());
            btnAtualizar.setEnabled(true);
            btnExcluir.setEnabled(true);
        }
    }

    
    private void atualizarAluno() {
        Aluno alunoSelecionado = (Aluno) comboBoxAlunos.getSelectedItem();
        if (alunoSelecionado != null) {
            alunoSelecionado.setNome(nomeField.getText());
            alunoSelecionado.setTelefone(telefoneField.getText());
            JOptionPane.showMessageDialog(this, "Aluno atualizado com sucesso.");
            atualizarComboBox();
            limparCampos();
        }
    }

   
    private void excluirAluno() {
        Aluno alunoSelecionado = (Aluno) comboBoxAlunos.getSelectedItem();
        if (alunoSelecionado != null) {
            int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                listaAlunos.remove(alunoSelecionado);
                JOptionPane.showMessageDialog(this, "Aluno excluído com sucesso.");
                atualizarComboBox();
                limparCampos();
            }
        }
    }

    
    private void limparCampos() {
        nomeField.setText("");
        telefoneField.setText("");
        btnAtualizar.setEnabled(false);
        btnExcluir.setEnabled(false);
    }
}
