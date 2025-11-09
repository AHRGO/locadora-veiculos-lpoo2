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

    //CRUDZÃO
    public void adicionaCliente(Cliente cliente) {
        this.linhas.add(cliente);
//        this.fireTableDataChanged(); ?? this shit works?? try it later
        this.fireTableRowsInserted(linhas.size()-1, linhas.size()-1);
    }

//    public Cliente
}
