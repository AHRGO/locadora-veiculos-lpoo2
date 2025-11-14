package br.com.locadora_veiculos.controller;

import br.com.locadora_veiculos.model.cliente.dao.ClienteDao;
import br.com.locadora_veiculos.model.dao.DaoFactory;
import br.com.locadora_veiculos.model.veiculo.dao.VeiculoDao;
import br.com.locadora_veiculos.view.TelaPrincipalView;
import br.com.locadora_veiculos.view.cliente.JanelaClienteView;

public class Main {
    public static void main(String[] args) {
        VeiculoController veiculoController = new VeiculoController();
        // veiculoController.criarVeiculo();

        TelaPrincipalView telaPrincipal = new TelaPrincipalView();

        ClienteDao model = DaoFactory.getClienteDao();
        JanelaClienteView clienteView = telaPrincipal.getClienteView();
        ClienteController controller = new ClienteController(clienteView, model);


    }
}
