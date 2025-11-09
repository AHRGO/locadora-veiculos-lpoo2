package br.com.locadora_veiculos.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//do magic stuff
public class ConnectionFactory {

    private static Properties dbProperties;

    private ConnectionFactory() {}

    private static void readProperties() throws IOException {
        if (dbProperties == null) {
            Properties propsFromFile = new Properties();
            FileInputStream fileWithProps = new FileInputStream(
                    ".src/main/java/br/com/locadora_veiculos/model/dao/DatabaseProperties.properties"
            );
            propsFromFile.load(fileWithProps);
            dbProperties = propsFromFile;
        }
    }

    public static Connection getConnection() throws SQLException, IOException {
        readProperties();
        String url = dbProperties.getProperty("db.url");
        String username = dbProperties.getProperty("db.username");
        String password = dbProperties.getProperty("db.password");

        return DriverManager.getConnection(url, username, password);
    }
}
