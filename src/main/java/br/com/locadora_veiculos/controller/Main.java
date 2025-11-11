package br.com.locadora_veiculos.controller;

import br.com.locadora_veiculos.model.Cliente;
import br.com.locadora_veiculos.model.dao.ClienteDao;
import br.com.locadora_veiculos.model.dao.DaoFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JanelaClienteView view = new JanelaClienteView();
        ClienteDao model = DaoFactory.getClienteDao();
        ClienteController controller = new ClienteController(view, model);

    }
}
