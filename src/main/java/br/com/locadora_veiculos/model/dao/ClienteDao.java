package br.com.locadora_veiculos.model.dao;

import br.com.locadora_veiculos.model.Cliente;

import java.util.List;

public interface ClienteDao extends Dao<Cliente> {
    public void deleteFromList(List<Cliente> clientes) throws Exception;


}
