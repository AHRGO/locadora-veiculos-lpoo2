package br.com.locadora_veiculos.controller;

import br.com.locadora_veiculos.model.cliente.Cliente;
import br.com.locadora_veiculos.model.cliente.dao.ClienteDao;
import br.com.locadora_veiculos.view.cliente.JanelaClienteView;

import java.util.List;

public class ClienteController {
    private JanelaClienteView view;
    private ClienteDao dao;

    public ClienteController(JanelaClienteView view, ClienteDao dao) {
        this.view = view;
        this.dao = dao;
       initController();
    }

    private void initController() {
        this.view.setController(this);
        this.view.initView();
    }

    public void criarCliente() {
       try {
           Cliente cliente = view.getClienteFormulario();
           dao.create(cliente);
           view.inserirClienteView(cliente);
           view.apresentaInfo("Cliente criado com sucesso");
       } catch(Exception e) {
           view.apresentaErro("Erro ao criar contato.");
           throw new RuntimeException(e);
       }
    }

    public void listarCliente() {
       try {
           view.limparClienteAtualizar();
           List<Cliente> listaClientes = this.dao.readAll();
           view.mostrarListaClientes(listaClientes);
       } catch(Exception e) {
           view.apresentaErro("Erro ao listar contatos.");
           e.printStackTrace();
           throw new RuntimeException(e);
       }
    }

    public void atualizarCliente() {
        try {
           Cliente cliente = view.getClienteParaAtualizar();
           if(cliente == null) {
               view.apresentaInfo("Selecione um cliente primeiro");
               return;
           }
           dao.updateOne(cliente);
           view.atualizarCliente(cliente);

        } catch (Exception e) {
           view.apresentaErro("Erro ao atualizar Cliente.");
            throw new RuntimeException(e);
        }
    }

    //TODO: ATUALIZAR REGRA PARA NÃO EXCLUIR UM CLIENTE COM VEÍCULO LOCADO
    public void excluirCliente() {
        try {
           List<Cliente> clientesParaExcluir = view.getClientesParaExcluir();
           dao.deleteFromList(clientesParaExcluir);
           view.excluirClientesView(clientesParaExcluir);
        } catch(Exception e) {
            view.apresentaErro("Erro ao excluir clientes.");
            throw new RuntimeException(e);
        }
    }


}
