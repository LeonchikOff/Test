package org.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesLoader {
    private PropertiesLoader() {
    }

    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream resourceAsStream = PropertiesLoader.class
                .getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(resourceAsStream);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    public static String getPropertyByKey(String key) {
        return PROPERTIES.getProperty(key);
    }
}
