package Servise;

import model.User;

import java.util.List;

public interface Service<T> {
    List<T> getAllUsers();
    void addObject(T object);
    void removeObject(T object);
    boolean isExist(T object);
    User findUser(Long id);
    default void editUser(User user) {
    }
}
