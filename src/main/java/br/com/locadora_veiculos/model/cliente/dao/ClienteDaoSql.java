package br.com.locadora_veiculos.model.cliente.dao;

import br.com.locadora_veiculos.model.cliente.Cliente;
import br.com.locadora_veiculos.model.dao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ClienteDaoSql implements ClienteDao{
    private ConnectionFactory connectionFactory;
    private static ClienteDaoSql clienteDao;

    private final String insert = "INSERT INTO cliente (nome, sobrenome, rg, cpf, endereco) VALUES (?,?,?,?,?)";
    private final String selectAll = "SELECT * FROM cliente";
    private final String selectById = "SELECT * FROM cliente WHERE id_cliente = ?";
    private final String update = "UPDATE cliente SET nome = ?, sobrenome = ?, rg = ?, cpf = ?, endereco = ? WHERE id_cliente = ?";
    private final String delete = "DELETE FROM cliente WHERE id_cliente = ?";
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
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement updateStatement = connection.prepareStatement(update);
        ) {
            updateStatement.setString(1, cliente.getNome());
            updateStatement.setString(2, cliente.getSobrenome());
            updateStatement.setString(3, cliente.getRg());
            updateStatement.setString(4, cliente.getCpf());
            updateStatement.setString(5, cliente.getEndereco());
            updateStatement.setLong(6, cliente.getId());

            updateStatement.executeUpdate();
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public void deleteOne(Cliente cliente) throws Exception {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement deleteByIdStatement = connection.prepareStatement(delete);
        ) {
            deleteByIdStatement.setLong(1, cliente.getId());
            deleteByIdStatement.executeUpdate();
        }
    }

    @Override
    public void deleteFromList(List<Cliente> clientes) throws Exception {
        for(Cliente cliente:clientes) {
            deleteOne(cliente);
        }
    }

    @Override
    public void deleteAll() throws Exception {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement deleteAllStatement = connection.prepareStatement(deleteAll);
        ) {
            deleteAllStatement.executeUpdate();
        }
        //TODO: ADICIONAR O CATCH
    }
}
