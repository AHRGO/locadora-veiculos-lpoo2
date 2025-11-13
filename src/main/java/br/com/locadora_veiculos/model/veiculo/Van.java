package br.com.locadora_veiculos.model.veiculo;

import br.com.locadora_veiculos.model.veiculo.enums.Categoria;
import br.com.locadora_veiculos.model.veiculo.enums.Estado;
import br.com.locadora_veiculos.model.veiculo.enums.Marca;
import br.com.locadora_veiculos.model.veiculo.enums.ModeloVan;

public class Van extends Veiculo {
    private Long id;
    private ModeloVan modelo;

    public Van(Locacao locacao, Marca marca, Estado estado, Categoria categoria, double valorDaCompra, String placa, int ano, Long veiculoId, ModeloAutomovel modelo) {
        super(locacao, marca, estado, categoria, valorDaCompra, placa, ano);
        this.id = veiculoId;
        this.modelo = modelo;
    }

    public Van(Locacao locacao, Marca marca, Estado estado, Categoria categoria, double valorDaCompra, String placa, int ano, ModeloVan modelo) {
        super(locacao, marca, estado, categoria, valorDaCompra, placa, ano);
        this.modelo = modelo;
    }


    @Override
    public double getValorDiariaLocacao() {
        return switch(super.getCategoria()) {
            case POPULAR -> 200.00;
            case INTERMEDIARIO -> 400.00;
            case LUXO -> 600.00;
        };
    }



    public ModeloVan getModelo() {
        return this.modelo;
    }


    public Long getVeiculoId() {
        return this.id;
    }
    public void setVeiculoId(Long veiculoId) {
        this.id = veiculoId;
    }


    public static Van convertFromDao(ResultSet result) throws SQLException {
        Long id = result.getLong("id_veiculo");
        Marca marca = Marca.fromString(result.getString("marca"));
        Estado estado = Estado.fromString(result.getString("estado"));
        Categoria categoria = Categoria.fromString(result.getString("categoria"));
        ModeloVan modelo = ModeloVan.fromString(result.getString("modelo"));
        double valorDaCompra = result.getDouble("valor_compra");
        String placa = result.getString("placa");
        int ano = result.getInt("ano");

        Locacao locacao = new Locacao();

        return new Van(locacao, marca, estado, categoria, valorDaCompra, placa, ano, id, modelo);
    }


    public static List<Van> converListFromDao(ResultSet result) throws SQLException {
        List<Van> vans = new ArrayList<>();

        while (result.next()) {
            vans.add(Van.convertFromDao(result));
        }

        return vans;
    }
    
}
