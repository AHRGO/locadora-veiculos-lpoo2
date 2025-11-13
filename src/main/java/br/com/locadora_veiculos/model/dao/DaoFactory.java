package br.com.locadora_veiculos.model.dao;

import br.com.locadora_veiculos.model.dao.cliente.ClienteDao;
import br.com.locadora_veiculos.model.dao.cliente.ClienteDaoSql;

public class DaoFactory {
    private DaoFactory() {}

    public static ClienteDao getClienteDao() {
        return ClienteDaoSql.getClienteDao();
    }
}
