package Servise;

import model.User;

import java.util.List;

public interface Service<T> {
    List<T> getAllUsers();
    void addObject(T object);
    void removeObject(T object);
    boolean isExist(T object);
    T findByLogin(String login);
    T findUser(Long id);
    void editUser(T object);
}
