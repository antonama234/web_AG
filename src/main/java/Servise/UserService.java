package Servise;

import DAO.UserDAO;
import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.List;

public class UserService implements Service<User> {
    private static UserService userService;
    private SessionFactory sessionFactory;

    private UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService(DBHelper.getSessionFactory());
        }
        return userService;
    }

    public UserDAO getUserDAO() {
        return new UserDAO(sessionFactory.openSession());
    }

    @Override
    public List<User> getAllUsers() {
        return getUserDAO().getAll();
    }

    @Override
    public void addObject(User object) {
        getUserDAO().add(object);
    }

    @Override
    public void removeObject(User object) {
        getUserDAO().delete(object);
    }

    @Override
    public boolean isExist(User user) {
        return getUserDAO().findByParams(user.getName(), user.getSurName(), user.getAge()) != null;
    }

    @Override
    public User findUser(Long id) {
        return getUserDAO().findById(id);
    }

    @Override
    public void editUser(User user) {
        getUserDAO().updateUser(user);
    }
}