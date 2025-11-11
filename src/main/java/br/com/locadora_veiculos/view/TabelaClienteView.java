package br.com.locadora_veiculos.view;

import javax.swing.*;

public class TabelaClienteView extends javax.swing.JPanel {
    private ClienteTableModel clienteTableModel = new ClienteTableModel();
    private JanelaClienteView JanelaClienteView janela;
    private int linhaClicadaParaAtualizacao = -1;

    private JScrollPane scrollPane //javax.swing.JScrollPane
    private JTable tabelaCliente //javax.swing.JTable

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
        )
    }

    private void tabelaClienteMouseClicked(MouseEvent event) {
        linhaClicadaParaAtualizacao = this.tabelaCliente.rowAtPoint(event.getPoint());

        Cliente cliente = clienteTableModel.getCliente(linhaClicadaParaAtualizacao);

        janela.getFormularioClienteView().setContato(contato);
    }

    public JTable getTabelaCliente() {
        return tabelaCliente;
    }


    public void setJanelaView(JanelaClienteView janela) {
        this.janela = janela;
    }

    public void setListaClientesTabela(List<Cliente> clientes) {
        clienteTableModel.setListaClientes(clientes);
    }

    public List<Cliente> getClientesParaExcluirDaTabela() {
        int[] linhasSelecionadas = this.getTabelaCliente().getSelectedRows();
        List<Cliente> clientesParaExcluir = new ArrayList<>();

        //TODO: VALIDAR UMA FORMA MAIS EFICIENTE DE FAZER ISSO AQUI
        for (int i = 0; i < linhasSelecionadas.length; i++) {
            Cliente cliente = clienteTableModel.getCliente(linhasSelecionadas[i]);
            clientesParaExcluir.add(cliente);
        }
    }

    public void excluirClientesDaTabela(List<Cliente> clientesParaExcluir) {
        clienteTableModel.removeMultiplosClientes(clientesParaExcluir);
    }

    public void atualizarClienteNaTabela(Cliente cliente) {
        clienteTableModel.fireTableRowsUpdated(linhaClicadaParaAtualizacao, linhaClicadaParaAtualizacao)
    }

}
