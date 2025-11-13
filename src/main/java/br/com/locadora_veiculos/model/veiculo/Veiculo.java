package br.com.locadora_veiculos.model.veiculo;

import br.com.locadora_veiculos.model.cliente.Cliente;
import br.com.locadora_veiculos.model.veiculo.enums.Categoria;
import br.com.locadora_veiculos.model.veiculo.enums.Estado;
import br.com.locadora_veiculos.model.veiculo.enums.Marca;

import java.util.Calendar;

public abstract class Veiculo implements VeiculoI {
    private Locacao locacao;
    private Marca marca;
    private Estado estado;
    private Categoria categoria;
    private double valorDaCompra;
    private String placa;
    private int ano;

    public Veiculo(Locacao locacao, Marca marca, Estado estado, Categoria categoria, double valorDaCompra, String placa, int ano) {
        this.locacao = locacao;
        this.marca = marca;
        this.estado = estado;
        this.categoria = categoria;
        this.valorDaCompra = valorDaCompra;
        this.placa = placa;
        this.ano = ano;
    }

    @Override
    public void locar(int dias, Calendar data, Cliente cliente) {
        Locacao novaLocacao = new Locacao();
        this.locacao = novaLocacao;
        this.estado = Estado.LOCADO;

        getValorDiariaLocacao();
    }

    @Override
    public void vender() {
        this.estado = Estado.VENDIDO;
    }

    @Override
    public void devolver() {
        this.locacao = null;
        this.estado = Estado.DISPONIVEL;
    }


    @Override
    public Estado getEstado() {
        return this.estado;
    }

    @Override
    public Marca getMarca() {
        return this.marca;
    }

    @Override
    public Categoria getCategoria() {
        return this.categoria;
    }

    @Override
    public Locacao getLocacao() {
        return this.locacao;
    }

    @Override
    public String getPlaca() {
        return this.placa;
    }

    @Override
    public int getAno() {
        return this.ano;
    }

    @Override
    public double getValorParaVenda() {
        double valorCompra = this.valorDaCompra;
        double idadeEmAnos = Calendar.getInstance().get(Calendar.YEAR) - this.ano;
        double valorDeVenda = valorCompra - idadeEmAnos * 0.15 *  valorCompra;

        if (valorDeVenda < valorCompra * 0.1) return valorCompra * 0.1;

        return valorDeVenda;
    }

    @Override
    public abstract double getValorDiariaLocacao();
}
