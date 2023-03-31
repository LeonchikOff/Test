package org.example.dao.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.example.util.PropertiesLoader;

import java.sql.Connection;
import java.sql.DriverManager;

@UtilityClass
public class ConnectionManager {

    static {
        try {
            Class.forName(PropertiesLoader.getPropertyByKey("db.jdbc.driver"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String URL_KEY = "db.url";
    private static final String USERNAME_KEY = "db.username";
    private static final String PASSWORD_KEY = "db.password";

    @SneakyThrows
    public static Connection getConnection() {
        return DriverManager.getConnection(
                PropertiesLoader.getPropertyByKey(URL_KEY),
                PropertiesLoader.getPropertyByKey(USERNAME_KEY),
                PropertiesLoader.getPropertyByKey(PASSWORD_KEY));
    }
}
