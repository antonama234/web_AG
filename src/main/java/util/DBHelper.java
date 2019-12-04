package util;

import model.User;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
    private static SessionFactory sessionFactory;
    private static Connection connection;
    private static Properties properties = DBProperties.getMyProperties();

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

    public static Connection getConnection() {
        if (connection == null) {
            connection = createConnection();
        }
        return connection;
    }

    @SuppressWarnings("UnusedDeclaration")
    private static Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.setProperty("hibernate.dialect", properties.getProperty("hibernate.dialect"));
        configuration.setProperty("hibernate.connection.driver_class", properties.getProperty("hibernate.connection.driver_class"));
        configuration.setProperty("hibernate.connection.url", properties.getProperty("hibernate.connection.url"));
        configuration.setProperty("hibernate.connection.username", properties.getProperty("hibernate.connection.username"));
        configuration.setProperty("hibernate.connection.password", properties.getProperty("hibernate.connection.password"));
        configuration.setProperty("hibernate.show_sql", properties.getProperty("hibernate.show_sql"));
        configuration.setProperty("hibernate.hbm2ddl.auto", properties.getProperty("hibernate.hbm2ddl.auto"));
        return configuration;
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = getMySqlConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    @SuppressWarnings("UnusedDeclaration")
    private static Connection createConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName(properties.getProperty("jdbc.connection.Driver")).newInstance());
            Connection connection = DriverManager.getConnection(
                    properties.getProperty("jdbc.connection.url"),
                    properties.getProperty("jdbc.connection.username"),
                    properties.getProperty("jdbc.connection.password"));
            connection.setAutoCommit(true);
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}
