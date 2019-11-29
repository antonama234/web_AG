package DAO;

import org.hibernate.SessionFactory;
import util.DBHelper;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class DAOFactory {
    private static DAOFactory instance;
    private static final String PATH_TO_PROPERTIES = "C:\\projects\\web_AG\\src\\main\\resources\\conf.properties";
    private Properties properties = new Properties();

    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public UserDAO getDAOFactory() {
        UserDAO dao = null;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            properties.load(fileInputStream);
            if (properties.getProperty("daoType").equals("Hibernate")) {
                SessionFactory sessionFactory = DBHelper.getSessionFactory();
                dao = UserDAOHibernate.getInstance(sessionFactory);
            } else if (properties.getProperty("daoType").equals("JCDB")) {
                Connection connection = DBHelper.getConnection();
                dao = UserDAOJDBC.getInstance(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dao;
    }
}
