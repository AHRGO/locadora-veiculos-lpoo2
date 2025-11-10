package br.com.locadora_veiculos.controller;

import br.com.locadora_veiculos.model.Cliente;
import br.com.locadora_veiculos.model.dao.ClienteDao;
import br.com.locadora_veiculos.view.JanelaClienteView;

import java.util.List;

public class ClienteController {
    private JanelaClienteView view;
    private ClienteDao dao;

    public ClienteController(JanelaClienteView view, ClienteDao dao) {
        this.view = view;
        this.dao = dao;
//        initController();
    }

    private void initController() {
        this.view.setController(this);
        this.view.initView();
    }

    //TODO: FINALIZAR MÉTODO
    public void criarCliente() {
//        try {
//            Cliente cliente = view.getClienteFormulario();
//            dao.create(cliente);
//            view.inserirClienteView(cliente);
//            view.apresentarInfo("Cliente criado com sucesso");
//        } catch(Exception e) {
////            view.apresentaErro("Erro ao criar contato.");
//            throw new RuntimeException(e);
//        }
    }

    //TODO: FINALIZAR MÉTODO
    public void listarCliente() {
//        try {
//            view.limparClientesAtualizar();
//            List<Cliente> listaClientes = this.dao.readAll();
//            view.mostrarListaClientes(listaClientes);
//        } catch(Exception e) {
////            view.apresentaErro("Erro ao listar contatos.");
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
    }

    //TODO: FINALIZAR MÉTODO
    public void atualizarCliente() {
        try {
//            Cliente cliente = view.getClienteParaAtualizar();
//            if(cliente == null) {
//                view.apresentaInfo("Selecione um cliente primeiro");
//                return;
//            }
//            dao.updateOne(cliente);
//            view.atualizarCliente(cliente);

        } catch (Exception e) {
//            view.apresentaErro("Erro ao atualizar contato.");
            throw new RuntimeException(e);
        }
    }

    //TODO: FINALIZAR MÉTODO
    public void excluirCliente() {
        try {
//            List<Cliente> clientesParaExcluir = view.getClientesParaExcluir();
//            dao.deleteFromList(clientesParaExcluir);
//            view.excluirClientesView(clientesParaExcluir);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }


}
