package br.com.locadora_veiculos.view.cliente;


import br.com.locadora_veiculos.controller.ClienteController;
import br.com.locadora_veiculos.model.Cliente;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JanelaClienteView extends javax.swing.JFrame {
    private BotoesClienteView botoesClienteView;
    private FormularioClienteView formularioClienteView;
    private TabelaClienteView tabelaClienteView;

    public BotoesClienteView getBotoesClienteView() {
        return botoesClienteView;
    }

    public FormularioClienteView getFormularioClienteView() {
        return formularioClienteView;
    }

    public TabelaClienteView getTabelaClienteView() {
        return tabelaClienteView;
    }



    public JanelaClienteView() {
       initComponents();
    }


    public void apresentaErro(String erro) {
        JOptionPane.showMessageDialog(null, erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null,info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }


    private void initComponents() {
        botoesClienteView = new BotoesClienteView();
        formularioClienteView = new FormularioClienteView();
        tabelaClienteView = new TabelaClienteView();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(formularioClienteView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tabelaClienteView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    )
                )
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            )
            .addComponent(botoesClienteView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(botoesClienteView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabelaClienteView, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(formularioClienteView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE)
            )
        );

        pack();

    }


    public void setController(ClienteController controller) {
       botoesClienteView.setController(controller);
    }

    public void initView() {
        tabelaClienteView.setJanelaView(this);
        EventQueue.invokeLater(() -> this.setVisible(true));
    }



    public Cliente getClienteFormulario() {
        return this.formularioClienteView.getClienteFormulario();
    }

    public void inserirClienteView(Cliente cliente) {
        tabelaClienteView.inserirClienteNaTabela(cliente);
    }

    public void mostrarListaClientes(List<Cliente> listaClientes) {
        tabelaClienteView.setListaClientesTabela(listaClientes);
    }

    public List<Cliente> getClientesParaExcluir () {
        return this.tabelaClienteView.getClientesParaExcluirDaTabela();
    }

    public void excluirClientesView(List<Cliente> clientesParaExcluir) {
        tabelaClienteView.excluirClientesDaTabela(clientesParaExcluir);
    }

    public Cliente getClienteParaAtualizar() {
        return formularioClienteView.getClienteParaAtualizar();
    }

    public void atualizarCliente(Cliente cliente) {
        tabelaClienteView.atualizarClienteNaTabela(cliente);
    }

    public void limparClienteAtualizar() {
        formularioClienteView.limparClienteParaAtualizar();
    }

}
