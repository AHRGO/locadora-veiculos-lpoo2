package br.com.locadora_veiculos.model.dao;

import br.com.locadora_veiculos.model.cliente.dao.ClienteDao;
import br.com.locadora_veiculos.model.cliente.dao.ClienteDaoSql;

public class DaoFactory {
    private DaoFactory() {}

    public static ClienteDao getClienteDao() {
        return ClienteDaoSql.getClienteDao();
    }
}
