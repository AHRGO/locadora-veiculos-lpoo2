package br.com.locadora_veiculos.view;

import br.com.locadora_veiculos.controller.ClienteController;

public class JanelaClienteView extends javax.swing.JFrame {
    private BotoesClienteView botoesClienteView;
    private FormularioClienteView formularioClienteView;
    // private TabelaClienteView tabelaClienteView;

    public JanelaClienteView() {
//        initComponents();
    }

    public void setController(ClienteController controller) {
        //TODO: CRIAR BOTOES CLIENTE VIEW
//        botoesClienteView.setController(controller);
    }

    public void initView() {
//        tabelaClienteView.setJanelaView(this);
        java.awt.EventQueue.invokeLater(() -> this.setVisible(true));
    }





    //TODO: CRIAR BOTOES CLIENTE VIEW
    //TODO: CRIAR FORMULARIO CLIENTE VIEW


}
