package br.com.locadora_veiculos.view.cliente;

import br.com.locadora_veiculos.model.cliente.Cliente;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TabelaClienteView extends JPanel {
    private ClienteTableModel clienteTableModel = new ClienteTableModel();
    private JanelaClienteView janela;
    private int linhaClicadaParaAtualizacao = -1;

    private JScrollPane scrollPane;
    private JTable tabelaCliente;

    public TabelaClienteView() {
        initComponents();
    }

    private void initComponents() {
        scrollPane = new JScrollPane();
        tabelaCliente = new JTable();

        tabelaCliente.setModel(clienteTableModel);
        tabelaCliente.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                tabelaClienteMouseClicked(event);
            }
        });

        scrollPane.setViewportView(tabelaCliente);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }

    private void tabelaClienteMouseClicked(MouseEvent event) {
        linhaClicadaParaAtualizacao = this.tabelaCliente.rowAtPoint(event.getPoint());

        Cliente cliente = clienteTableModel.getCliente(linhaClicadaParaAtualizacao);

        janela.getFormularioClienteView().setCliente(cliente);
    }

    public JTable getTabelaCliente() {
        return tabelaCliente;
    }


    public void setJanelaView(JanelaClienteView janela) {
        this.janela = janela;
    }

    public void inserirClienteNaTabela(Cliente cliente) {
        clienteTableModel.adicionaCliente(cliente);
    }

    public void setListaClientesTabela(List<Cliente> clientes) {
        clienteTableModel.setListaClientes(clientes);
    }

    public List<Cliente> getClientesParaExcluirDaTabela() {
        int[] linhasSelecionadas = this.getTabelaCliente().getSelectedRows();
        List<Cliente> clientesParaExcluir = new ArrayList<>();

        for (int i = 0; i < linhasSelecionadas.length; i++) {
            Cliente cliente = clienteTableModel.getCliente(linhasSelecionadas[i]);
            clientesParaExcluir.add(cliente);
        }

        return clientesParaExcluir;
    }

    public void excluirClientesDaTabela(List<Cliente> clientesParaExcluir) {
        clienteTableModel.removeMultiplosClientes(clientesParaExcluir);
    }

    public void atualizarClienteNaTabela(Cliente cliente) {
        clienteTableModel.fireTableRowsUpdated(linhaClicadaParaAtualizacao, linhaClicadaParaAtualizacao);
    }

}
