package br.com.locadora_veiculos.model.veiculo.dao;

import br.com.locadora_veiculos.model.dao.ConnectionFactory;
import br.com.locadora_veiculos.model.veiculo.Motocicleta;
import br.com.locadora_veiculos.model.veiculo.enums.TipoVeiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class MotocicletaDaoSql implements VeiculoDao<Motocicleta> {
    private ConnectionFactory connectionFactory;
    private static MotocicletaDaoSql motocicletaDao;

    private final String insert = "A SQL QUERY";
    private final String selectAll = "A SQL QUERY";
    private final String selectById = "A SQL QUERY";
    private final String update = "A SQL QUERY";
    private final String delete = "A SQL QUERY";
    private final String deleteAll = "A SQL QUERY";

    private MotocicletaDaoSql() {}

    public static MotocicletaDaoSql getMotocicletaDao() {
        if (motocicletaDao == null) return motocicletaDao = new MotocicletaDaoSql();
        return motocicletaDao;
    }

    public MotocicletaDaoSql(ConnectionFactory conFac) {
        this.connectionFactory = conFac;
    }

    //TODO: VALIDAR
    @Override
    public void create(Motocicleta motocicleta) throws Exception {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement insertStatement = connection.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            insertStatement.setString(1, TipoVeiculo.MOTOCICLETA.name());
            insertStatement.setString(2, motocicleta.getMarca().name());
            insertStatement.setString(3, motocicleta.getEstado().name());
            insertStatement.setString(4, motocicleta.getCategoria().name());
            insertStatement.setString(5, motocicleta.getModelo().name());
//            insertStatement.setDouble(6, motocicleta.getValorDaCompra());
            insertStatement.setString(7, motocicleta.getPlaca());
            insertStatement.setInt(8, motocicleta.getAno());

            // insertStatement.setString(1, motocicleta.getLocacao()); => TODO: O CONTROLLER VAI ORQUESTRAR O SALVAMENTO DE DIFERENTES CONTROLLERS,
                // DIZENDO QUANDO É A VEZ DE QUEM FAZER O QUE

            insertStatement.execute();

            ResultSet result = insertStatement.getGeneratedKeys();
            result.next();

            Long veiculoId = result.getLong(1);
            motocicleta.setVeiculoId(veiculoId);
        } catch(Exception e) {
            throw new Exception(e);
        }

    }

    //TODO: VALIDAR
    @Override
    public List<Motocicleta> readAll() throws Exception {
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement readAllStatement = connection.prepareStatement(selectAll);
                ResultSet resultSet = readAllStatement.executeQuery();
        ) {
            return Motocicleta.converListFromDao(resultSet);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    //TODO: VALIDAR
    @Override
    public Motocicleta readOne(Long veiculoId) throws Exception {
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement readByIdStatement = connection.prepareStatement(selectById);
        ) {
            readByIdStatement.setLong(1, veiculoId);
            ResultSet result = readByIdStatement.executeQuery();

            return Motocicleta.convertFromDao(result);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    //TODO: VALIDAR
    @Override
    public void updateOne(Motocicleta motocicleta) throws Exception {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement updateStatement = connection.prepareStatement(update);
        ) {
            updateStatement.setString(1, TipoVeiculo.MOTOCICLETA.name());
            updateStatement.setString(2, motocicleta.getMarca().name());
            updateStatement.setString(3, motocicleta.getEstado().name());
            updateStatement.setString(4, motocicleta.getCategoria().name());
            updateStatement.setString(5, motocicleta.getModelo().name());
//            updateStatement.setDouble(6, motocicleta.getValorDaCompra());
            updateStatement.setString(7, motocicleta.getPlaca());
            updateStatement.setInt(8, motocicleta.getAno());
//            updateStatement.setLong(9, motocicleta.getId());

            updateStatement.executeUpdate();
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    //TODO: VALIDAR
    @Override
    public void deleteOne(Motocicleta motocicleta) throws Exception {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement deleteByIdStatement = connection.prepareStatement(delete);
        ) {
//            deleteByIdStatement.setLong(1, motocicleta.getId());
            deleteByIdStatement.executeUpdate();
        }
    }

    //TODO: VALIDAR NECESSIDADE
//    @Override
//    public void deleteFromList(List<Motocicleta> motos) throws Exception {
//        for(Motocicleta motocicleta:motos) {
//            deleteOne(motocicleta);
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