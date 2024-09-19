package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.cfg.Configuration;


public class Util {
    private static final String login = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/test";

    private Util() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        try {
            Configuration configuration = getConfiguration();
            return configuration.buildSessionFactory();
        } catch (JDBCException e) {
            System.out.println("Ошибка подключения БД");
            throw new RuntimeException(e);
        } catch (HibernateException e) {
            System.out.println("Ошибка конфигурации Hibernate");
            throw new RuntimeException(e);
        }
    }

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", url);
        configuration.setProperty("hibernate.connection.username", login);
        configuration.setProperty("hibernate.connection.password", password);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");

        configuration.addAnnotatedClass(User.class);

        return configuration;
    }
}
