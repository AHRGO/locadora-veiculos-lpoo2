package br.com.locadora_veiculos.model.veiculo.mock;

import br.com.locadora_veiculos.model.veiculo.Automovel;
import br.com.locadora_veiculos.model.veiculo.Locacao;
import br.com.locadora_veiculos.model.veiculo.Motocicleta;
import br.com.locadora_veiculos.model.veiculo.Van;
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

    public static Automovel mockAutomovelDois() {
        tipo = TipoVeiculo.AUTOMOVEL;
        marca = Marca.VOLKSWAGEN;
        estado = Estado.LOCADO;
        categoria = Categoria.LUXO;
        valorCompra = 213000;
        placa = "AAA-123";
        ano = 2022;

        modeloAutomovel = ModeloAutomovel.PALIO;


        return new Automovel(marca, estado, categoria, valorCompra, placa, ano, modeloAutomovel);
    }

    public static Motocicleta mockMotocicletaUm() {
        tipo = TipoVeiculo.MOTOCICLETA;
        marca = Marca.HONDA;
        estado = Estado.NOVO;
        categoria = Categoria.LUXO;
        valorCompra = 50000;
        placa = "PAF-785";
        ano = 2025;

        modeloMotocicleta = ModeloMotocicleta.CBR_500;


        return new Motocicleta(marca, estado, categoria, valorCompra, placa, ano, modeloMotocicleta);
    }

    public static Van mockVanUm() {
        tipo = TipoVeiculo.VAN;
        marca = Marca.FIAT;
        estado = Estado.LOCADO;
        categoria = Categoria.POPULAR;
        valorCompra = 76000;
        placa = "LLO-145";
        ano = 2014;

        modeloVan = ModeloVan.SPRINTER;


        return new Van(marca, estado, categoria, valorCompra, placa, ano, modeloVan);
    }
}
