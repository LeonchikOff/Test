package org.example.a_dao.util;

import org.example.util.PropertiesLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    private ConnectionManager() {
    }

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


    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    PropertiesLoader.getPropertyByKey(URL_KEY),
                    PropertiesLoader.getPropertyByKey(USERNAME_KEY),
                    PropertiesLoader.getPropertyByKey(PASSWORD_KEY));
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }

    }
}
