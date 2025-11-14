package br.com.locadora_veiculos.model.veiculo.dao;

import br.com.locadora_veiculos.model.dao.ConnectionFactory;
import br.com.locadora_veiculos.model.veiculo.Van;
import br.com.locadora_veiculos.model.veiculo.enums.TipoVeiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class VanDaoSql implements VeiculoDao<Van> {
    private ConnectionFactory connectionFactory;
    private static VanDaoSql vanDao;

    private final String insert = "INSERT INTO veiculo (tipo, marca, estado, categoria, modelo, valor_compra, placa, ano) VALUES (?,?,?,?,?,?,?,?)";
    private final String selectAll = "A SQL QUERY";
    private final String selectById = "A SQL QUERY";
    private final String update = "A SQL QUERY";
    private final String delete = "A SQL QUERY";
    private final String deleteAll = "A SQL QUERY";

    private VanDaoSql() {}

    public static VanDaoSql getVanDao() {
        if (vanDao == null) return vanDao = new VanDaoSql();
        return vanDao;
    }

    public VanDaoSql(ConnectionFactory conFac) {
        this.connectionFactory = conFac;
    }

    //TODO: VALIDAR
    @Override
    public void create(Van van) throws Exception {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement insertStatement = connection.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            insertStatement.setString(1, TipoVeiculo.VAN.name());
            insertStatement.setString(2, van.getMarca().name());
            insertStatement.setString(3, van.getEstado().name());
            insertStatement.setString(4, van.getCategoria().name());
            insertStatement.setString(5, van.getModelo().name());
            insertStatement.setDouble(6, van.getValorDaCompra());
            insertStatement.setString(7, van.getPlaca());
            insertStatement.setInt(8, van.getAno());

            // insertStatement.setString(1, van.getLocacao()); => TODO: O CONTROLLER VAI ORQUESTRAR O SALVAMENTO DE DIFERENTES CONTROLLERS,
                // DIZENDO QUANDO É A VEZ DE QUEM FAZER O QUE

            insertStatement.execute();

            ResultSet result = insertStatement.getGeneratedKeys();
            result.next();

            Long veiculoId = result.getLong(1);
            van.setVeiculoId(veiculoId);
        } catch(Exception e) {
            throw new Exception(e);
        }

    }

    //TODO: VALIDAR
    @Override
    public List<Van> readAll() throws Exception {
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement readAllStatement = connection.prepareStatement(selectAll);
                ResultSet resultSet = readAllStatement.executeQuery();
        ) {
            return Van.converListFromDao(resultSet);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    //TODO: VALIDAR
    @Override
    public Van readOne(Long veiculoId) throws Exception {
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement readByIdStatement = connection.prepareStatement(selectById);
        ) {
            readByIdStatement.setLong(1, veiculoId);
            ResultSet result = readByIdStatement.executeQuery();

            return Van.convertFromDao(result);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    //TODO: VALIDAR
    @Override
    public void updateOne(Van van) throws Exception {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement updateStatement = connection.prepareStatement(update);
        ) {
            updateStatement.setString(1, TipoVeiculo.VAN.name());
            updateStatement.setString(2, van.getMarca().name());
            updateStatement.setString(3, van.getEstado().name());
            updateStatement.setString(4, van.getCategoria().name());
            updateStatement.setString(5, van.getModelo().name());
//            updateStatement.setDouble(6, van.getValorDaCompra());
            updateStatement.setString(7, van.getPlaca());
            updateStatement.setInt(8, van.getAno());
//            updateStatement.setLong(9, van.getId());

            updateStatement.executeUpdate();
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    //TODO: VALIDAR
    @Override
    public void deleteOne(Van van) throws Exception {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement deleteByIdStatement = connection.prepareStatement(delete);
        ) {
//            deleteByIdStatement.setLong(1, van.getId());
            deleteByIdStatement.executeUpdate();
        }
    }

    //TODO: VALIDAR NECESSIDADE
//    @Override
//    public void deleteFromList(List<Van> tenis) throws Exception {
//        for(Van van:tenis) {
//            deleteOne(van);
//        }
//    }

    //TODO: VALIDAR
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