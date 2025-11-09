package br.com.locadora_veiculos.model.dao;

public class DaoFactory {
    private DaoFactory() {}

    public static ClienteDao getClienteDao() {
        return ClienteDaoSql.getClienteDao();
    }
}
