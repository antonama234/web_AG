package DAO;

import org.hibernate.SessionFactory;
import util.DBHelper;
import util.DBProperties;

import java.sql.Connection;
import java.util.Properties;

public class DAOFactory {
    private static DAOFactory instance;

    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public UserDAO getDAOFactory() {
        UserDAO dao = null;
        Properties properties = DBProperties.getMyProperties();
        if (properties.getProperty("daoType").equals("Hibernate")) {
            SessionFactory sessionFactory = DBHelper.getSessionFactory();
            dao = UserDAOHibernate.getInstance(sessionFactory);
        } else if (properties.getProperty("daoType").equals("JCDB")) {
            Connection connection = DBHelper.getConnection();
            dao = UserDAOJDBC.getInstance(connection);
        }
        return dao;
    }
}
