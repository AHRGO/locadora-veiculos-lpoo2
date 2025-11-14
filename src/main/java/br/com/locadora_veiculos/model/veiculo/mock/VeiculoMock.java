package br.com.locadora_veiculos.model.veiculo.mock;

import br.com.locadora_veiculos.model.veiculo.Automovel;
import br.com.locadora_veiculos.model.veiculo.Locacao;
import br.com.locadora_veiculos.model.veiculo.enums.*;

public class VeiculoMock {
    private static TipoVeiculo tipo;
    private static Marca marca;
    private static Estado estado;
    private static Categoria categoria;
    private static double valorCompra;
    private static String placa;
    private static Integer ano;

    private static ModeloAutomovel modeloAutomovel;
    private static ModeloMotocicleta modeloMotocicleta;
    private static ModeloVan modeloVan;

    Locacao locacaoVazia = new Locacao(0, 0.0, null, null);

    public static Automovel mockAutomovelUm() {
        tipo = TipoVeiculo.AUTOMOVEL;
        marca = Marca.FIAT;
        estado = Estado.DISPONIVEL;
        categoria = Categoria.POPULAR;
        valorCompra = 45000.63;
        placa = "XYZ-123";
        ano = 2021;

        modeloAutomovel = ModeloAutomovel.CELTA;


        return new Automovel(marca, estado, categoria, valorCompra, placa, ano, modeloAutomovel);
    }
}
