package br.com.locadora_veiculos.model.veiculo;

import br.com.locadora_veiculos.model.cliente.Cliente;

import java.util.Calendar;

public class Locacao {
    private int dias;
    private double valor;
    private Calendar data;
    private Cliente cliente;

    public Locacao(int dias, double valor, Calendar data, Cliente cliente) {
        this.dias = dias;
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
    }
}
