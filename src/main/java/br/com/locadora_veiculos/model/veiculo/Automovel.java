package br.com.locadora_veiculos.model.veiculo;

import br.com.locadora_veiculos.model.veiculo.enums.Categoria;
import br.com.locadora_veiculos.model.veiculo.enums.Estado;
import br.com.locadora_veiculos.model.veiculo.enums.Marca;
import br.com.locadora_veiculos.model.veiculo.enums.ModeloAutomovel;

public class Automovel extends Veiculo {
    private ModeloAutomovel modelo;

    public Automovel(Locacao locacao, Marca marca, Estado estado, Categoria categoria, double valorDaCompra, String placa, int ano, ModeloAutomovel modelo) {
        super(locacao, marca, estado, categoria, valorDaCompra, placa, ano);
        this.modelo = modelo;
    }

    public ModeloAutomovel getModelo() {
        return this.modelo;
    }

    @Override
    public double getValorDiariaLocacao() {
        return switch(super.getCategoria()) {
            case POPULAR -> 100.00;
            case INTERMEDIARIO -> 300.00;
            case LUXO -> 450.00;
        };
    }
}
