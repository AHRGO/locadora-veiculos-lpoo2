package br.com.locadora_veiculos.view;

import br.com.locadora_veiculos.controller.ClienteController;

import javax.swing.*;

public class BotoesClienteView extends javax.swing.JPanel {
    private JButton botaoCriar;
    private JButton botaoListar;
    private JButton botaoAtualizar;
    private JButton botaoExcluir;

    public BotoesClienteView() {
//        initComponents();
    }



    private void initComponents() {
        inicializarBotoes();

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        //TODO: TESTAR SE ESSA IMPLEMENTAÇÃO FUNCIONA
        criarGrupoHorizontal(layout);
        criarGrupoVertical(layout);

//        layout.setHorizontalGroup(
//                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(
//                                layout.createSequentialGroup()
//                                        .addComponent(botaoCriar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
//                                        .addGap(18,18,18)
//                                        .addComponent(botaoAtualizar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
//                                        .addGap(37,37,37)
//                                        .addComponent(botaoExcluir, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
//                                        .addGap(18,18,18)
//                                        .addComponent(botaoListar, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
//                                        .addContainerGap()
//                        )
//        );

//        layout.setVerticalGroup(
//                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addGroup(
//                                        layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                        .addComponent(botaoCriar)
//                                        .addComponent(botaoAtualizar)
//                                        .addComponent(botaoExcluir)
//                                        .addComponent(botaoListar))
//                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );


    }

    private void inicializarBotoes() {
        botaoCriar = new JButton();
        botaoListar = new JButton();
        botaoAtualizar = new JButton();
        botaoExcluir = new JButton();

        botaoCriar.setText("Criar");
        botaoListar.setText("Listar");
        botaoAtualizar.setText("Atualizar");
        botaoExcluir.setText("Excluir");
    }

    private void criarGrupoHorizontal(GroupLayout layout) {
        //TODO: REMOVER NÚMEROS MÁGICOS
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(botaoCriar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18,18,18)
                                        .addComponent(botaoAtualizar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                        .addGap(37,37,37)
                                        .addComponent(botaoExcluir, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18,18,18)
                                        .addComponent(botaoListar, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                        .addContainerGap()
                        )
        );
    }

    private void criarGrupoVertical(GroupLayout layout) {
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(botaoCriar)
                                                .addComponent(botaoAtualizar)
                                                .addComponent(botaoExcluir)
                                                .addComponent(botaoListar))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }

    public void setController(
            ClienteController controller
    ) {
        this.botaoCriar.addActionListener(e -> controller.criarCliente());
        this.botaoListar.addActionListener(e -> controller.listarCliente());
        this.botaoAtualizar.addActionListener(e -> controller.atualizarCliente());
        this.botaoExcluir.addActionListener(e -> controller.excluirCliente());
    }

}
