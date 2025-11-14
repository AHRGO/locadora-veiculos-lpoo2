package br.com.locadora_veiculos.model.veiculo.dao;

import br.com.locadora_veiculos.model.dao.ConnectionFactory;
import br.com.locadora_veiculos.model.veiculo.Automovel;
import br.com.locadora_veiculos.model.veiculo.enums.TipoVeiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class AutomovelDaoSql implements VeiculoDao<Automovel> {
    private ConnectionFactory connectionFactory;
    private static AutomovelDaoSql automovelDao;

    private final String insert = "A SQL QUERY";
    private final String selectAll = "A SQL QUERY";
    private final String selectById = "A SQL QUERY";
    private final String update = "A SQL QUERY";
    private final String delete = "A SQL QUERY";
    private final String deleteAll = "A SQL QUERY";

    private AutomovelDaoSql() {}

    public static AutomovelDaoSql getAutomovelDao() {
        if (automovelDao == null) return automovelDao = new AutomovelDaoSql();
        return automovelDao;
    }

    public AutomovelDaoSql(ConnectionFactory conFac) {
        this.connectionFactory = conFac;
    }

    //TODO: VALIDAR
    @Override
    public void create(Automovel automovel) throws Exception {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement insertStatement = connection.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            insertStatement.setString(1, TipoVeiculo.AUTOMOVEL.name());
            insertStatement.setString(2, automovel.getMarca().name());
            insertStatement.setString(3, automovel.getEstado().name());
            insertStatement.setString(4, automovel.getCategoria().name());
            insertStatement.setString(5, automovel.getModelo().name());
//            insertStatement.setDouble(6, automovel.getValorDaCompra());
            insertStatement.setString(7, automovel.getPlaca());
            insertStatement.setInt(8, automovel.getAno());

            // insertStatement.setString(1, automovel.getLocacao()); => TODO: O CONTROLLER VAI ORQUESTRAR O SALVAMENTO DE DIFERENTES CONTROLLERS,
                // DIZENDO QUANDO É A VEZ DE QUEM FAZER O QUE

            insertStatement.execute();

            ResultSet result = insertStatement.getGeneratedKeys();
            result.next();

            Long veiculoId = result.getLong(1);
            automovel.setVeiculoId(veiculoId);
        } catch(Exception e) {
            throw new Exception(e);
        }

    }

    //TODO: VALIDAR
    @Override
    public List<Automovel> readAll() throws Exception {
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement readAllStatement = connection.prepareStatement(selectAll);
                ResultSet resultSet = readAllStatement.executeQuery();
        ) {
            return Automovel.converListFromDao(resultSet);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    //TODO: VALIDAR
    @Override
    public Automovel readOne(Long veiculoId) throws Exception {
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement readByIdStatement = connection.prepareStatement(selectById);
        ) {
            readByIdStatement.setLong(1, veiculoId);
            ResultSet result = readByIdStatement.executeQuery();

            return Automovel.convertFromDao(result);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    //TODO: VALIDAR
    @Override
    public void updateOne(Automovel automovel) throws Exception {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement updateStatement = connection.prepareStatement(update);
        ) {
            updateStatement.setString(1, TipoVeiculo.AUTOMOVEL.name());
            updateStatement.setString(2, automovel.getMarca().name());
            updateStatement.setString(3, automovel.getEstado().name());
            updateStatement.setString(4, automovel.getCategoria().name());
            updateStatement.setString(5, automovel.getModelo().name());
//            updateStatement.setDouble(6, automovel.getValorDaCompra());
            updateStatement.setString(7, automovel.getPlaca());
            updateStatement.setInt(8, automovel.getAno());
//            updateStatement.setLong(9, automovel.getId());

            updateStatement.executeUpdate();
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    //TODO: VALIDAR
    @Override
    public void deleteOne(Automovel automovel) throws Exception {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement deleteByIdStatement = connection.prepareStatement(delete);
        ) {
//            deleteByIdStatement.setLong(1, automovel.getId());
            deleteByIdStatement.executeUpdate();
        }
    }

    //TODO: VALIDAR NECESSIDADE
//    @Override
//    public void deleteFromList(List<Automovel> automoveis) throws Exception {
//        for(Automovel automovel:automoveis) {
//            deleteOne(automovel);
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