package br.com.locadora_veiculos.model.veiculo;

import br.com.locadora_veiculos.model.veiculo.enums.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Automovel extends Veiculo {
    private Long id;
    private ModeloAutomovel modelo;


    public Automovel(Locacao locacao, Marca marca, Estado estado, Categoria categoria, double valorDaCompra, String placa, int ano, Long veiculoId, ModeloAutomovel modelo) {
        super(locacao, marca, estado, categoria, valorDaCompra, placa, ano);
        this.id = veiculoId;
        this.modelo = modelo;
    }


    public Automovel(Locacao locacao, Marca marca, Estado estado, Categoria categoria, double valorDaCompra, String placa, int ano, ModeloAutomovel modelo) {
        super(locacao, marca, estado, categoria, valorDaCompra, placa, ano);
        this.modelo = modelo;
    }



    @Override
    public double getValorDiariaLocacao() {
        return switch(super.getCategoria()) {
            case POPULAR -> 100.00;
            case INTERMEDIARIO -> 300.00;
            case LUXO -> 450.00;
        };
    }


    public TipoVeiculo getTipo() {
        return TipoVeiculo.AUTOMOVEL;
    }

    public ModeloAutomovel getModelo() {
        return this.modelo;
    }

    public List<String> getModelos() {
        List<String> modelos = new ArrayList<>();
        for(ModeloAutomovel modelo : ModeloAutomovel.values()) {
            modelos.add(modelo.getNomeExibicao());
        }

        return modelos;
    }


    public Long getVeiculoId() {
        return this.id;
    }
    public void setVeiculoId(Long veiculoId) {
        this.id = veiculoId;
    }



    public static Automovel convertFromDao(ResultSet result) throws SQLException {
        Long id = result.getLong("id_veiculo");
        Marca marca = Marca.fromString(result.getString("marca"));
        Estado estado = Estado.fromString(result.getString("estado"));
        Categoria categoria = Categoria.fromString(result.getString("categoria"));
        ModeloAutomovel modelo = ModeloAutomovel.fromString(result.getString("modelo"));
        double valorDaCompra = result.getDouble("valor_compra");
        String placa = result.getString("placa");
        int ano = result.getInt("ano");

        Locacao locacao = new Locacao(0, 0.0, null, null);

        return new Automovel(locacao, marca, estado, categoria, valorDaCompra, placa, ano, id, modelo);
    }


    public static List<Automovel> converListFromDao(ResultSet result) throws SQLException {
        List<Automovel> automoveis = new ArrayList<>();

        while (result.next()) {
            automoveis.add(Automovel.convertFromDao(result));
        }

        return automoveis;
    }


}
