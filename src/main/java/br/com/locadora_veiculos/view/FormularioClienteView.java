package br.com.locadora_veiculos.view;

import br.com.locadora_veiculos.model.Cliente;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class FormularioClienteView extends javax.swing.JPanel {
    private Cliente clienteSelecionadoParaAtualizacao;

//    private JTextField campoId; ???
    private JTextField campoNome;
    private JTextField campoSobrenome;
    private JFormattedTextField campoRg;
    private JFormattedTextField campoCpf;
    private JTextField campoEndereco;
    private JLabel labelNome;
    private JLabel labelSobrenome;
    private JLabel labelRg;
    private JLabel labelCpf;
    private JLabel labelEndereco;

    public FormularioClienteView() {
//        initComponents();
    }

    private void initComponents() {
        campoNome = new JTextField();
        campoSobrenome = new JTextField();
        campoRg = new JFormattedTextField();
        campoCpf = new JFormattedTextField();
        campoEndereco = new JTextField();

        labelNome = new JLabel();
        labelSobrenome = new JLabel();
        labelRg = new JLabel();
        labelCpf = new JLabel();
        labelEndereco = new JLabel();

        labelNome.setText("Nome");
        labelSobrenome.setText("Sobrenome");
        labelRg.setText("Rg");
        labelCpf.setText("Cpf");
        labelEndereco.setText("Endereco");

        try {
            campoRg.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##.###.###-#")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            campoCpf.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



}
