package br.com.locadora_veiculos.view;

import javax.swing.*;

public class TabelaClienteView extends javax.swing.JPanel{
    private ClienteTableModel clienteTableModel = new ClienteTableModel();

    private void initPanel() {
        JScrollPane scrollPane = new JScrollPane();
        JTable tableView = new javax.swing.JTable();
    }
}
