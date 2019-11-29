package Servise;

import DAO.UserDAO;
import DAO.DAOFactory;
import model.User;

import java.util.List;

public class UserService implements UService {
    private static UserService instance;
    private UserDAO dao;

    private UserService(UserDAO dao) {
        this.dao = dao;
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService(DAOFactory.getInstance().getDAOFactory());
        }
        return instance;
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAll();
    }

    @Override
    public void addObject(User object) {
        dao.add(object);
    }

    @Override
    public void removeObject(User object) {
        dao.delete(object);
    }

    @Override
    public boolean isExist(User user) {
        return dao.findByParams(user.getName(), user.getSurName(), user.getAge()) != null;
    }

    @Override
    public User findUser(Long id) {
        return dao.findById(id);
    }

    @Override
    public void editUser(User user) {
        dao.updateUser(user);
    }
}