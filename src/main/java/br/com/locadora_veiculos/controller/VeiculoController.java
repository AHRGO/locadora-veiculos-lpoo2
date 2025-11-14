package br.com.locadora_veiculos.controller;

import br.com.locadora_veiculos.model.veiculo.dao.VeiculoDao;

public class VeiculoController {
    //TODO: IMPLEMENTAR VIEW
    //    private VeiculoView view;
    private VeiculoDao dao;

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

    }

    //TODO: IMPLEMENTAR FUTURAMENTE
    public void listarVeiculo() {}

    //TODO: IMPLEMENTAR FUTURAMENTE
    public void atualizarVeiculo() {}

    //TODO: IMPLEMENTAR FUTURAMENTE
    public void excluirVeiculo() {}
}
