package br.com.locadora_veiculos.model.veiculo;

import br.com.locadora_veiculos.model.veiculo.enums.Categoria;
import br.com.locadora_veiculos.model.veiculo.enums.Estado;
import br.com.locadora_veiculos.model.veiculo.enums.Marca;
import br.com.locadora_veiculos.model.veiculo.enums.ModeloVan;

public class Van extends Veiculo {
    private ModeloVan modelo;

    public Van(Locacao locacao, Marca marca, Estado estado, Categoria categoria, double valorDaCompra, String placa, int ano, ModeloVan modelo) {
        super(locacao, marca, estado, categoria, valorDaCompra, placa, ano);
        this.modelo = modelo;
    }

    public ModeloVan getModelo() {
        return this.modelo;
    }

    @Override
    public double getValorDiariaLocacao() {
        return switch(super.getCategoria()) {
            case POPULAR -> 200.00;
            case INTERMEDIARIO -> 400.00;
            case LUXO -> 600.00;
        };
    }
}
