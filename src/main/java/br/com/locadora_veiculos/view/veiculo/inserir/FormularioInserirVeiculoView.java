//package br.com.locadora_veiculos.view.veiculo.inserir;
//
//import javax.swing.*;
//
////TODO
//public class FormularioInserirVeiculoView extends JPanel {
//
//
//    /*
//     *
//     *
//     * private double valorDaCompra;
//        private String placa;
//        private int ano;
//     *
//     *
//     * */
//
//
//
//    private JTextField campoMarca; //Alterar para ComboBox
//    private JTextField campoEstado; //Combobox
//    private JTextField campoCategoria; //Combobox
//    private JTextField campoValorDaCompra;
//    private JTextField campoAno;
//    private JTextField campoTipoVeiculo; //Alterar para ComboBox
//    private JFormattedTextField campoPlaca; //Adicionar validador + mascara
//
//    private JFormattedTextField campoModeloVeiculo; //Alterar para ComboBox; depende do tipo do veículo
//
////TODO: Criar método que itera por sobre os enums e devolve uma lista de Strings, sendo esta o textoExibicao
//
///*
//uma possível implementação é:
//ter um tipo de lista (provavelmente String) que contenha, genericamente, os modelos.
//
//inicializar essa lista antes
//
//conforme mudam-se os valores, são carregados os modelos específicos do veiculo nessa lista
//
//
//*/
//
////Quaisquer outros campos necessários
//
//    //private JTextField campoEndereco;
//    private JLabel labelMarca;
//    private JLabel labelTipoVeiculo;
//    private JLabel labelPlaca;
//    private JLabel labelModeloVeiculo;
//    //private JLabel labelEndereco;
//
//    public FormularioInserirVeiculoView() {
//       initComponents();
//    }
//
//    private void initComponents() {
//        campoNome = new JTextField();
//        campoSobrenome = new JTextField();
//        campoRg = new JFormattedTextField();
//        campoCpf = new JFormattedTextField();
//        campoEndereco = new JTextField();
//
//        labelNome = new JLabel();
//        labelSobrenome = new JLabel();
//        labelRg = new JLabel();
//        labelCpf = new JLabel();
//        labelEndereco = new JLabel();
//
//        labelNome.setText("Nome");
//        labelSobrenome.setText("Sobrenome");
//        labelRg.setText("Rg");
//        labelCpf.setText("Cpf");
//        labelEndereco.setText("Endereco");
//
//        try {
//            campoRg.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##.###.###-#")));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            campoCpf.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        desenharPanel();
//    }
//
//    private void desenharPanel() {
//        GroupLayout layout = new GroupLayout(this);
//        this.setLayout(layout);
//
//        criarGrupoHorizontal(layout);
//        criarGrupoVertical(layout);
//    }
//
//    private void criarGrupoHorizontal(GroupLayout layout) {
//        layout.setHorizontalGroup(
//                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                                        .addGroup(layout.createSequentialGroup()
//                                                .addComponent(labelNome)
//                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                                                .addComponent(campoNome)
//                                        )
//                                        .addGroup(layout.createSequentialGroup()
//                                                .addComponent(labelSobrenome)
//                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(campoSobrenome)
//                                        )
//                                        .addGroup(layout.createSequentialGroup()
//                                                .addComponent(labelRg)
//                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(campoRg)
//                                        )
//                                        .addGroup(layout.createSequentialGroup()
//                                                .addComponent(labelCpf)
//                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(campoCpf)
//                                        )
//                                        .addGroup(layout.createSequentialGroup()
//                                                .addComponent(labelEndereco)
//                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(campoEndereco)
//                                        )
//                                )
//                                .addContainerGap()
//                        )
//
//        );
//    }
//
//    private void criarGrupoVertical(GroupLayout layout) {
//        layout.setVerticalGroup(
//                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                        .addComponent(labelNome)
//                                        .addComponent(campoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
//                                )
//                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                        .addComponent(labelSobrenome)
//                                        .addComponent(campoSobrenome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
//                                )
//                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                        .addComponent(labelRg)
//                                        .addComponent(campoRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
//                                )
//                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                        .addComponent(labelCpf)
//                                        .addComponent(campoCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
//                                )
//                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                        .addComponent(labelEndereco)
//                                        .addComponent(campoEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
//                                )
//                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                        )
//        );
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.clienteSelecionadoParaAtualizacao = cliente;
//        campoNome.setText(cliente.getNome());
//        campoSobrenome.setText(cliente.getSobrenome());
//        campoRg.setText(cliente.getRg());
//        campoCpf.setText(cliente.getCpf());
//        campoEndereco.setText(cliente.getEndereco());
//    }
//
//    public void limparClienteParaAtualizar() {
//        clienteSelecionadoParaAtualizacao = null;
//    }
//
//    public Cliente getClienteParaAtualizar() {
//        if(clienteSelecionadoParaAtualizacao == null) return null;
//
//        clienteSelecionadoParaAtualizacao.setNome(campoNome.getText());
//        clienteSelecionadoParaAtualizacao.setSobrenome(campoSobrenome.getText());
//        clienteSelecionadoParaAtualizacao.setRg(campoRg.getText());
//        clienteSelecionadoParaAtualizacao.setCpf(campoCpf.getText());
//        clienteSelecionadoParaAtualizacao.setEndereco(campoEndereco.getText());
//
//        return clienteSelecionadoParaAtualizacao;
//    }
//
//    public Cliente getClienteFormulario() {
//        String nome = campoNome.getText();
//        String sobrenome = campoSobrenome.getText();
//        String rg = campoRg.getText();
//        String cpf = campoCpf.getText();
//        String endereco = campoEndereco.getText();
//
//        return new Cliente(nome, sobrenome, rg, cpf, endereco);
//    }
//
//
//}
//
//
