package br.com.locadora_veiculos.controller;

import br.com.locadora_veiculos.model.cliente.dao.ClienteDao;
import br.com.locadora_veiculos.model.dao.DaoFactory;
import br.com.locadora_veiculos.view.TelaPrincipalView;
import br.com.locadora_veiculos.view.cliente.JanelaClienteView;

public class Main {
    public static void main(String[] args) {
        JanelaClienteView view = new JanelaClienteView();
        ClienteDao model = DaoFactory.getClienteDao();
        ClienteController controller = new ClienteController(view, model);
        TelaPrincipalView telaPrincipal = new TelaPrincipalView(view);

    }
}
