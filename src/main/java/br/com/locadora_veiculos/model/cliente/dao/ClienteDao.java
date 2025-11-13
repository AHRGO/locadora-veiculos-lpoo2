package br.com.locadora_veiculos.model.cliente.dao;

import br.com.locadora_veiculos.model.cliente.Cliente;
import br.com.locadora_veiculos.model.dao.Dao;

import java.util.List;

public interface ClienteDao extends Dao<Cliente> {
    public void deleteFromList(List<Cliente> clientes) throws Exception;


}
