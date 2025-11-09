package br.com.locadora_veiculos.view;

import br.com.locadora_veiculos.model.Cliente;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ClienteTableModel extends AbstractTableModel {
    private String[] colunas = new String[]{"id, Nome, Sobrenome, RG, CPF, Endereço"};
    private List<Cliente> linhas = new ArrayList<>();


    public ClienteTableModel() {};

    public ClienteTableModel(List<Cliente> clientes) {this.linhas = clientes;}

    @Override
    public int getRowCount() {
        return this.linhas.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = this.linhas.get(rowIndex);
        return switch(columnIndex) {
            case 0 -> cliente.getId();
            case 1 -> cliente.getNome();
            case 2 -> cliente.getSobrenome();
            case 3 -> cliente.getRg();
            case 4 -> cliente.getCpf();
            case 5 -> cliente.getEndereco();
            default -> null;
        };
    }

    //removeCliente

    public void adicionaCliente(Cliente cliente) {
        this.linhas.add(cliente);
//        this.fireTableDataChanged(); ?? this shit works?? try it later
        this.fireTableRowsInserted(linhas.size()-1, linhas.size()-1);
    }

    public void setListaClientes(List<Cliente> clientes) {
        this.linhas = clientes;
        this.fireTableDataChanged();
    }

    public void limpaTabela() {
        int primeiraLinha = 0;
        int ultimaLinha = linhas.size()-1;


        if(ultimaLinha < 0) ultimaLinha = 0;

        this.linhas = new ArrayList<>();
        this.fireTableRowsDeleted(primeiraLinha, ultimaLinha);
    }

    public Cliente getCliente(int linhaIndex) {
        return linhas.get(linhaIndex);
    }

    public boolean removeCliente(Cliente cliente) {
        int indexOndeEstavaCliente = this.linhas.indexOf(cliente);
        boolean clienteFoiRemovido = this.linhas.remove(cliente);

        this.fireTableRowsDeleted(indexOndeEstavaCliente, indexOndeEstavaCliente);
        return clienteFoiRemovido;
    }

    public void removeMultiplosClientes(List<Cliente> clientes) {
        clientes.forEach(this::removeCliente);
    }



}
