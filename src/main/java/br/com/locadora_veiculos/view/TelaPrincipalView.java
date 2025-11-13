package br.com.locadora_veiculos.view;

import br.com.locadora_veiculos.view.cliente.JanelaClienteView;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipalView extends JFrame {

    //TODO: MELHORAR FLUXO DE INICIALIZAÇÃO PARA NÃO PRECISAR PASSAR POR PARÂMETRO
    public TelaPrincipalView(JanelaClienteView janelaClient) {
        setTitle("Locadora de Veículos");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane abas = criaAbas(janelaClient);
        add(abas, BorderLayout.CENTER);
        setVisible(true);
    }

    private JTabbedPane criaAbas(JanelaClienteView janelaClient) {
        JTabbedPane abas = new JTabbedPane();

        JPanel abaClientes = new JPanel();
        abaClientes.add(janelaClient);

        JPanel abaVeiculos = new JPanel();
        abaVeiculos.add(new JLabel("O conteúdo da tela de Veículos será disponibilizado em breve"));

        JPanel abaLocacao = new JPanel();
        abaLocacao.add(new JLabel("O conteúdo da tela de Locação será disponibilizado em breve"));


        abas.addTab("Clientes", abaClientes);
        abas.addTab("Veículos", abaVeiculos);
        abas.addTab("Locação", abaLocacao);

        return abas;
    }
}
