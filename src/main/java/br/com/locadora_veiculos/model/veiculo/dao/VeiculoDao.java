package br.com.locadora_veiculos.model.veiculo.dao;

import br.com.locadora_veiculos.model.dao.Dao;
import br.com.locadora_veiculos.model.veiculo.Automovel;
import br.com.locadora_veiculos.model.veiculo.Veiculo;



public interface VeiculoDao extends Dao<Veiculo> {
    //TODO: VALIDAR
    void create(Automovel automovel) throws Exception;
    //TODO: VALIDAR IMPLEMENTAÇÃO DE DELETE FROM LIST
}
