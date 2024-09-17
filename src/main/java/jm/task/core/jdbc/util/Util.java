package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String login = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/test";

    private Util() {
    }

    public static Connection getConnection() {
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
