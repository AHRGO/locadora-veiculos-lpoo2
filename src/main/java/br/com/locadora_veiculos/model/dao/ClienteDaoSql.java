package br.com.locadora_veiculos.model.dao;

import br.com.locadora_veiculos.model.Cliente;
import br.com.locadora_veiculos.model.Endereco;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoSql implements ClienteDao{
    private ConnectionFactory connectionFactory;
    private static ClienteDaoSql clienteDao;

    private final String insert = "INSERT INTO cliente (nome, sobrenome, rg, cpf, endereco) VALUES (?,?,?,?,?)";
    private final String selectAll = "SELECT * FROM cliente";
    private final String selectById = "SELECT * FROM cliente WHERE id_cliente = ?";
    private final String update = "UPDATE cliente SET nome = ?, sobrenome = ?, rg = ?, cpf = ?, endereco = ? WHERE id_cliente = ?";
    private final String delete = "DELETE FROM cliente WHERE cliente_id = ?";
    private final String deleteAll = "DELETE FROM cliente";

    private ClienteDaoSql() {}

    public static ClienteDaoSql getClienteDao() {
        if (clienteDao == null) return clienteDao = new ClienteDaoSql();
        return clienteDao;
    }

    public ClienteDaoSql(ConnectionFactory conFac) {
        this.connectionFactory = conFac;
    }



    @Override
    public void create(Cliente cliente) throws Exception {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement insertStatement = connection.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            insertStatement.setString(1, cliente.getNome());
            insertStatement.setString(2, cliente.getSobrenome());
            insertStatement.setString(3, cliente.getRg());
            insertStatement.setString(4, cliente.getCpf());
            insertStatement.setString(5, cliente.getEndereco());

            insertStatement.execute();

            ResultSet result = insertStatement.getGeneratedKeys();
            result.next();

            Long clienteId = result.getLong(1);
            cliente.setId(clienteId);
        } catch(Exception e) {
            throw new Exception(e);
        }

    }

    @Override
    public List<Cliente> readAll() throws Exception {
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement readAllStatement = connection.prepareStatement(selectAll);
                ResultSet resultSet = readAllStatement.executeQuery();
        ) {
            return Cliente.converListFromDao(resultSet);
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    @Override
    public Cliente readOne(Long clienteId) throws Exception {
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement readByIdStatement = connection.prepareStatement(selectById);
        ) {
            readByIdStatement.setLong(1, clienteId);
            ResultSet result = readByIdStatement.executeQuery();

            return Cliente.convertFromDao(result);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public void updateOne(Cliente cliente) throws Exception {

    }

    @Override
    public void deleteOne(Cliente cliente) throws Exception {

    }

    @Override
    public void deleteAll() throws Exception {

    }

//    @Override
//    public Long criaCliente(Cliente cliente, Endereco endereco) {
//
//        return 0L;
//    }
//
//    @Override
//    public Cliente getClienteById(Long clienteId) {
//
//        return null;
//    }
//
//    @Override
//    public void atualizaClienteById(Long clienteId) {
//
//    }
//
//    @Override
//    public void deleteClienteById(Long clienteId) {
//
//    }
}
