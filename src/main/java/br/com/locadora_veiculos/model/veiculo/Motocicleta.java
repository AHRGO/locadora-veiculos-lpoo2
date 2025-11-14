package br.com.locadora_veiculos.model.veiculo;

import br.com.locadora_veiculos.model.veiculo.enums.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Motocicleta extends Veiculo {
    private Long id;
    private ModeloMotocicleta modelo;

    public Motocicleta(Locacao locacao, Marca marca, Estado estado, Categoria categoria, double valorDaCompra, String placa, int ano, Long veiculoId, ModeloMotocicleta modelo) {
        super(locacao, marca, estado, categoria, valorDaCompra, placa, ano);
        this.id = veiculoId;
        this.modelo = modelo;
    }

    public Motocicleta(Locacao locacao, Marca marca, Estado estado, Categoria categoria, double valorDaCompra, String placa, int ano, ModeloMotocicleta modelo) {
        super(locacao, marca, estado, categoria, valorDaCompra, placa, ano);
        this.modelo = modelo;
    }



    @Override
    public double getValorDiariaLocacao() {
        return switch(super.getCategoria()) {
            case POPULAR -> 70.00;
            case INTERMEDIARIO -> 200.00;
            case LUXO -> 300.00;
        };
    }


    public TipoVeiculo getTipo() {
        return TipoVeiculo.MOTOCICLETA;
    }

    public ModeloMotocicleta getModelo() {
        return this.modelo;
    }

    public List<String> getModelos() {
        List<String> modelos = new ArrayList<>();
        for(ModeloMotocicleta modelo : ModeloMotocicleta.values()) {
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


    public static Motocicleta convertFromDao(ResultSet result) throws SQLException {
        Long id = result.getLong("id_veiculo");
        Marca marca = Marca.fromString(result.getString("marca"));
        Estado estado = Estado.fromString(result.getString("estado"));
        Categoria categoria = Categoria.fromString(result.getString("categoria"));
        ModeloMotocicleta modelo = ModeloMotocicleta.fromString(result.getString("modelo"));
        double valorDaCompra = result.getDouble("valor_compra");
        String placa = result.getString("placa");
        int ano = result.getInt("ano");

        Locacao locacao = new Locacao(0, 0.0, null, null);

        return new Motocicleta(locacao, marca, estado, categoria, valorDaCompra, placa, ano, id, modelo);
    }


    public static List<Motocicleta> converListFromDao(ResultSet result) throws SQLException {
        List<Motocicleta> motos = new ArrayList<>();

        while (result.next()) {
            motos.add(Motocicleta.convertFromDao(result));
        }

        return motos;
    }
    
}
