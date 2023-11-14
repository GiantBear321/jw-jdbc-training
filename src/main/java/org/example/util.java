package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class util {
    private static final Properties DB_PROPERTIES;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    static {
        DB_PROPERTIES = new Properties();
        DB_PROPERTIES.setProperty("user", "root");
        DB_PROPERTIES.setProperty("password", "root1234");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cant find driver");
        }
    }

    public static Connection getConnection() throws SQLException {
            return  DriverManager
                    .getConnection(DB_URL, DB_PROPERTIES);
    }
}
