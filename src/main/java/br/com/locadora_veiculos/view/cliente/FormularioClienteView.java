package br.com.locadora_veiculos.view.cliente;

import br.com.locadora_veiculos.model.cliente.Cliente;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class FormularioClienteView extends JPanel {
    private Cliente clienteSelecionado;

    private JTextField campoNome;
    private JTextField campoSobrenome;
    private JFormattedTextField campoRg;
    private JFormattedTextField campoCpf;
    private JTextField campoEndereco;
    private JLabel labelNome;
    private JLabel labelSobrenome;
    private JLabel labelRg;
    private JLabel labelCpf;
    private JLabel labelEndereco;

    public FormularioClienteView() {
       initComponents();
    }

    private void initComponents() {
        campoNome = new JTextField();
        campoSobrenome = new JTextField();
        campoRg = new JFormattedTextField();
        campoCpf = new JFormattedTextField();
        campoEndereco = new JTextField();

        labelNome = new JLabel();
        labelSobrenome = new JLabel();
        labelRg = new JLabel();
        labelCpf = new JLabel();
        labelEndereco = new JLabel();

        labelNome.setText("Nome");
        labelSobrenome.setText("Sobrenome");
        labelRg.setText("Rg");
        labelCpf.setText("Cpf");
        labelEndereco.setText("Endereco");

        try {
            campoRg.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##.###.###-#")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            campoCpf.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
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
                                                .addComponent(labelNome)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(campoNome)
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelSobrenome)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoSobrenome)
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelRg)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoRg)
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelCpf)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoCpf)
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelEndereco)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoEndereco)
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
                                        .addComponent(labelNome)
                                        .addComponent(campoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelSobrenome)
                                        .addComponent(campoSobrenome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelRg)
                                        .addComponent(campoRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelCpf)
                                        .addComponent(campoCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelEndereco)
                                        .addComponent(campoEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        )
        );
    }

    public void setCliente(Cliente cliente) {
        this.clienteSelecionado = cliente;
        campoNome.setText(cliente.getNome());
        campoSobrenome.setText(cliente.getSobrenome());
        campoRg.setText(cliente.getRg());
        campoCpf.setText(cliente.getCpf());
        campoEndereco.setText(cliente.getEndereco());
    }

    public void limparClienteParaAtualizar() {
        clienteSelecionado = null;
    }

    public Cliente getClienteParaAtualizar() {
        if(clienteSelecionado == null) return null;

        clienteSelecionado.setNome(campoNome.getText());
        clienteSelecionado.setSobrenome(campoSobrenome.getText());
        clienteSelecionado.setRg(campoRg.getText());
        clienteSelecionado.setCpf(campoCpf.getText());
        clienteSelecionado.setEndereco(campoEndereco.getText());

        return clienteSelecionado;
    }

    public Cliente getClienteFormulario() {
        String nome = campoNome.getText();
        String sobrenome = campoSobrenome.getText();
        String rg = campoRg.getText();
        String cpf = campoCpf.getText();
        String endereco = campoEndereco.getText();

        return new Cliente(nome, sobrenome, rg, cpf, endereco);
    }


}
