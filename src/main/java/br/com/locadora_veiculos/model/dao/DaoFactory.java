package br.com.locadora_veiculos.model.dao;

import br.com.locadora_veiculos.model.cliente.dao.ClienteDao;
import br.com.locadora_veiculos.model.cliente.dao.ClienteDaoSql;
import br.com.locadora_veiculos.model.veiculo.Automovel;
import br.com.locadora_veiculos.model.veiculo.dao.AutomovelDaoSql;
import br.com.locadora_veiculos.model.veiculo.dao.MotocicletaDaoSql;
import br.com.locadora_veiculos.model.veiculo.dao.VanDaoSql;
import br.com.locadora_veiculos.model.veiculo.dao.VeiculoDao;

public class DaoFactory {
    private DaoFactory() {}

    public static ClienteDao getClienteDao() {
        return ClienteDaoSql.getClienteDao();
    }

    public static AutomovelDaoSql getAutomovelDao() {
        return AutomovelDaoSql.getAutomovelDao();
    }

    public static MotocicletaDaoSql getMotocicletaDao() {
        return MotocicletaDaoSql.getMotocicletaDao();
    }

    public static VanDaoSql getVanDao() {
        return VanDaoSql.getVanDao();
    }


}
