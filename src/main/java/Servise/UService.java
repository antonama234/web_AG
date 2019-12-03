package Servise;

import model.User;

import java.util.List;

public interface UService extends Service<User> {
    List<User> getAllUsers();
    void addObject(User object);
    void removeObject(User object);
    boolean isExist(User object);
    User findByLogin(String login);
    User findUser(Long id);
    void editUser(User object);
}
