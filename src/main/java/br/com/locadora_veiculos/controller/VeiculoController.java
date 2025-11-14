package br.com.locadora_veiculos.controller;

import br.com.locadora_veiculos.model.dao.DaoFactory;
import br.com.locadora_veiculos.model.veiculo.Automovel;
import br.com.locadora_veiculos.model.veiculo.Motocicleta;
import br.com.locadora_veiculos.model.veiculo.Van;
import br.com.locadora_veiculos.model.veiculo.Veiculo;
import br.com.locadora_veiculos.model.veiculo.dao.AutomovelDaoSql;
import br.com.locadora_veiculos.model.veiculo.dao.MotocicletaDaoSql;
import br.com.locadora_veiculos.model.veiculo.dao.VanDaoSql;
import br.com.locadora_veiculos.model.veiculo.dao.VeiculoDao;
import br.com.locadora_veiculos.model.veiculo.enums.TipoVeiculo;
import br.com.locadora_veiculos.model.veiculo.mock.VeiculoMock;

public class VeiculoController {
    //TODO: IMPLEMENTAR VIEW
    //    private VeiculoView view;
    private VeiculoDao dao;

    AutomovelDaoSql automovelDao;
    MotocicletaDaoSql motocicletaDao;
    VanDaoSql vanDao;


    public VeiculoController(
//            VeiculoView view,
        VeiculoDao dao
    ) {
//        this.view = view;
        this.dao = dao;
        initController();
    }

    public void initController() {
        //TODO: MÉTODOS DA VIEW
    }

    public void criarVeiculo() {
        try {
            Veiculo veiculo = VeiculoMock.mockAutomovelUm();
            TipoVeiculo tipo = getTipoVeiculo(veiculo);

            switch(tipo) {
                case AUTOMOVEL -> {
                    automovelDao = DaoFactory.getAutomovelDao();
                    automovelDao.create(((Automovel) veiculo));
                }
                case MOTOCICLETA -> {
                    motocicletaDao = DaoFactory.getMotocicletaDao();
                    motocicletaDao.create(((Motocicleta) veiculo));
                }
                case VAN -> {
                    vanDao = DaoFactory.getVanDao();
                    vanDao.create(((Van) veiculo));
                }

            }

            System.out.println("Deu certo!");

        } catch(Exception e) {
            throw new RuntimeException(e);
        }

    }

    //TODO: IMPLEMENTAR FUTURAMENTE
    public void listarVeiculo() {}

    //TODO: IMPLEMENTAR FUTURAMENTE
    public void atualizarVeiculo() {}

    //TODO: IMPLEMENTAR FUTURAMENTE
    public void excluirVeiculo() {}




    // TODO: IMPLEMENTAR CHAMADAS NAS VIEWS DE VEÍCULO
    public static TipoVeiculo getTipoVeiculo(Veiculo veiculo) {
//        Veiculo veiculo = this.veiculoSelecionado;

        if(veiculo != null) {
            if(veiculo instanceof Automovel) {
                return ((Automovel) veiculo).getTipo();
            } else if (veiculo instanceof Motocicleta) {
                return ((Motocicleta) veiculo).getTipo();
            } else if (veiculo instanceof Van) {
                return ((Van) veiculo).getTipo();
            }
        } else {
            throw new IllegalArgumentException("Nenhum veículo foi selecionado/instanciado");
        }

        return null;
    }
}
