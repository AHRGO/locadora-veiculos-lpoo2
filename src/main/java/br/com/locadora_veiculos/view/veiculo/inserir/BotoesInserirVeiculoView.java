package br.com.locadora_veiculos.view.veiculo;

import javax.swing.*;

//TODO: MUDAR DEPOIS PARA BOTOES INCLUIR VEICULO VIEW
public class BotoesInserirVeiculoView extends JPanel {
    private JButton botaoListar;
    private JButton botaoCriar;

    public BotoesInserirVeiculoView() {
        initComponents();
    }

    private void initComponents() {
        botaoListar = new JButton();
        botaoCriar = new JButton();

        botaoListar.setText("Listar");
        botaoCriar.setText("Criar");

        desenharPanel();
    }

    private void desenharPanel() {
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        criarGrupoHorizontal(layout);
        criarGrupoVertical(layout);
    }

    private void criarGrupoHorizontal(GroupLayout layout) {
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoListar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(20,20,20)
                                .addComponent(botaoCriar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()
                        )
        );
    }

    private void criarGrupoVertical(GroupLayout layout) {
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(botaoListar)
                                        .addComponent(botaoCriar)
                                )
                                .addContainerGap()
                        )
        );
    }


    //TODO: FINALIZAR APÓS CRIAR MÉTODOS NO DAO E CONTROLLER
    public void setController(
//            VeiculoController controller
    ) {
//        this.botaoListar.addActionListener(e -> controller.listarTodosVeiculos());
//        this.botaoCriar.addActionListener(e -> controller.criarVeiculo());
    }

}
