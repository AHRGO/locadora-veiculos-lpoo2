package br.com.locadora_veiculos.view;

import br.com.locadora_veiculos.view.cliente.JanelaClienteView;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipalView extends JFrame {
    private JanelaClienteView janelaClientView;

    public JanelaClienteView getClienteView() {
        return janelaClientView;
    }

    public TelaPrincipalView() {
        initComponents();
    }

    private void initComponents() {
        janelaClientView = new JanelaClienteView();

        setTitle("Locadora de Veículos");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(criaAbas(janelaClientView), BorderLayout.CENTER);
        setVisible(true);
    }

    private JTabbedPane criaAbas(JanelaClienteView janelaClient) {
        JTabbedPane abas = new JTabbedPane();

        JPanel abaClientes = new JPanel();
        abaClientes.add(janelaClient);

        JPanel abaVeiculos = new JPanel();
        abaVeiculos.add(criaAbaVeiculos());


        abas.addTab("Clientes", abaClientes);
        abas.addTab("Veículos", abaVeiculos);

        return abas;
    }

    //TODO: VALIDAR FUNCIONAMENTO
    private JTabbedPane criaAbaVeiculos() {
        JTabbedPane abaVeiculos = new JTabbedPane();

        JPanel abaAdicionar = new JPanel();
        abaAdicionar.add(new JLabel("O conteúdo desta tela será disponibilizado em breve"));

        JPanel abaLocar = new JPanel();
        abaLocar.add(new JLabel("O conteúdo desta tela será disponibilizado em breve"));

        JPanel abaDevolver = new JPanel();
        abaDevolver.add(new JLabel("O conteúdo desta tela será disponibilizado em breve"));

        JPanel abaVender = new JPanel();
        abaVender.add(new JLabel("O conteúdo desta tela será disponibilizado em breve"));

        abaVeiculos.addTab("Incluir Novos Veículos", abaAdicionar);
        abaVeiculos.addTab("Locar Veículos", abaLocar);
        abaVeiculos.addTab("Devolver Veículos", abaDevolver);
        abaVeiculos.addTab("Vender Veículos", abaVender);

        return abaVeiculos;
    }
}
