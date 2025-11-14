package br.com.locadora_veiculos.view.veiculo.inserir;

import br.com.locadora_veiculos.model.veiculo.Automovel;
import br.com.locadora_veiculos.model.veiculo.Motocicleta;
import br.com.locadora_veiculos.model.veiculo.Van;
import br.com.locadora_veiculos.model.veiculo.Veiculo;
import br.com.locadora_veiculos.model.veiculo.enums.Categoria;
import br.com.locadora_veiculos.model.veiculo.enums.Estado;
import br.com.locadora_veiculos.model.veiculo.enums.Marca;
import br.com.locadora_veiculos.model.veiculo.enums.TipoVeiculo;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FormularioInserirVeiculoView extends JPanel {
    private Veiculo veiculoSelecionado;
    private String[] comboModeloVeiculo;

    private JComboBox<TipoVeiculo> campoTipo;
    private JComboBox<Marca> campoMarca;
    private JComboBox<Estado> campoEstado;
    private JComboBox<Categoria> campoCategoria;
    private JComboBox<String> campoModelo;
    private JFormattedTextField campoValorDaCompra;
    private JFormattedTextField campoPlaca;
    private JTextField campoAno;

    private JLabel labelTipo;
    private JLabel labelMarca;
    private JLabel labelEstado;
    private JLabel labelCategoria;
    private JLabel labelModelo;
    private JLabel labelValorDaCompra;
    private JLabel labelPlaca;
    private JLabel labelAno;




    public FormularioInserirVeiculoView() {
       initComponents();
    }

    private void initComponents() {
        comboModeloVeiculo = new String[]{};

        campoTipo = new JComboBox<>(TipoVeiculo.values());
        campoMarca = new JComboBox<>(Marca.values());
        campoEstado = new JComboBox<>(Estado.values());
        campoCategoria = new JComboBox<>(Categoria.values());
        campoModelo = new JComboBox<>(comboModeloVeiculo);
        campoValorDaCompra = new JFormattedTextField();
        campoPlaca = new JFormattedTextField();
        campoAno = new JTextField();

        labelTipo = new JLabel();
        labelMarca = new JLabel();
        labelEstado = new JLabel();
        labelCategoria = new JLabel();
        labelModelo = new JLabel();
        labelValorDaCompra = new JLabel();
        labelPlaca = new JLabel();
        labelAno = new JLabel();

        labelTipo.setText("Tipo Veículo");
        labelMarca.setText("Marca Veículo");
        labelEstado.setText("Estado Locação");
        labelCategoria.setText("Categoria Veículo");
        labelModelo.setText("Modelo Veículo");
        labelValorDaCompra.setText("Valor Da Compra");
        labelPlaca.setText("Placa");
        labelAno.setText("Ano");


        try {
            campoValorDaCompra.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("R$ ####,##")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            campoPlaca.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###-###")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelTipo)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(campoTipo)
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelMarca)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoMarca)
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelEstado)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoEstado)
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelCategoria)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoCategoria)
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelModelo)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoModelo)
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelValorDaCompra)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoValorDaCompra)
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelPlaca)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoPlaca)
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelAno)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoAno)
                                        )
                                )
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
                                        .addComponent(labelTipo)
                                        .addComponent(campoTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelMarca)
                                        .addComponent(campoMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelEstado)
                                        .addComponent(campoEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelCategoria)
                                        .addComponent(campoCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelModelo)
                                        .addComponent(campoModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelValorDaCompra)
                                        .addComponent(campoValorDaCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelPlaca)
                                        .addComponent(campoPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelAno)
                                        .addComponent(campoAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        )
        );
    }

    public void setVeiculo( Veiculo veiculo) {
        this.veiculoSelecionado = veiculo;

        TipoVeiculo tipoVeiculo = getTipoVeiculo();
        setComboModeloVeiculo(tipoVeiculo);

        campoTipo.setSelectedItem(tipoVeiculo);
        campoMarca.setSelectedItem(veiculo.getMarca());
        campoEstado.setSelectedItem(veiculo.getEstado());
        campoCategoria.setSelectedItem(veiculo.getCategoria());
        campoModelo.setSelectedItem(comboModeloVeiculo);
//        campoValorDaCompra.setText(veiculo.getValorDaCompra()); TODO: EXCLUIR ISSO DO MODEL E NOS SELECTS, NUNCA TRAZER ESSE CAMPO
        campoPlaca.setText(veiculo.getPlaca());
        campoAno.setText(String.format("%d", veiculo.getAno()));
    }

    public void limparVeiculoParaAtualizar() {
        veiculoSelecionado = null;
    }

    //TODO: DESCOBRIR O QUE FAZER
//    public Veiculo getVeiculoParaAtualizar() {
//        if(veiculoSelecionado == null) return null;
//
//        veiculoSelecionado

//                .setMarca(campoNome.getText());
//        veiculoSelecionado.setSobrenome(campoSobrenome.getText());
//        veiculoSelecionado.setRg(campoRg.getText());
//        veiculoSelecionado.setCpf(campoCpf.getText());
//        veiculoSelecionado.setEndereco(campoEndereco.getText());
//
//        return veiculoSelecionado;
//    }


    public void getVeiculoFormulario() {
//    public Veiculo getVeiculoFormulario() {
        String textoTipo = campoTipo.getSelectedItem().toString();
        String textoMarca = campoMarca.getSelectedItem().toString();
        String textoEstado = campoEstado.getSelectedItem().toString();
        String textoCategoria = campoCategoria.getSelectedItem().toString();
        String textoModelo = campoModelo.getSelectedItem().toString();
        String textoValorDaCompra = campoValorDaCompra.getText();
        String textoPlaca = campoPlaca.getText();
        String textoAno = campoAno.getText();

        //TODO: FAZER  campoTipo.getSelectedItem() RETORNAR O TIPO E A PARTIR DELE CRIAR CADA OBJETO DO TIPO CERTO
            //  AUTOMOVEL, MOTOCICLETA OU VAN, E INSTANCIAR AS COISAS CONFORME FOR NECESSÁRIO

//        return new Veiculo(nome, sobrenome, rg, cpf, endereco);
    }


    private TipoVeiculo getTipoVeiculo() {
        Veiculo veiculo = this.veiculoSelecionado;

        if(veiculoSelecionado != null) {
            if(veiculo instanceof Automovel) {
                return ((Automovel) veiculo).getTipo();
            } else if (veiculo instanceof Motocicleta) {
                return ((Motocicleta) veiculo).getTipo();
            } else if (veiculo instanceof Van) {
                return ((Van) veiculo).getTipo();
            }
        } else {
            throw new IllegalArgumentException("Nenhum veículo foi selecionado/instanciado");
        }

        return null;
    }

    private void setComboModeloVeiculo(TipoVeiculo tipo) {
//        if(veiculoSelecionado == null) throw new IllegalArgumentException("Veículo não foi instanciado");

        List<String> modelos = new ArrayList<>();
//        TipoVeiculo tipo = getTipoVeiculo();

        switch(Objects.requireNonNull(tipo)){
            case AUTOMOVEL -> modelos = ((Automovel) veiculoSelecionado).getModelos();
            case MOTOCICLETA -> modelos = ((Motocicleta) veiculoSelecionado).getModelos();
            case VAN -> modelos = ((Van) veiculoSelecionado).getModelos();
        }

        this.comboModeloVeiculo = modelos.toArray(String[]::new);
    }

}


