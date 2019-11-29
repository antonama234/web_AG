package DAO;

import model.User;

import java.util.List;

public interface UserDAO extends DAO<User> {
    List<User> getAll();
    void add(User entity);
    void delete(User entity);
    User findById(Long id);
    User findByParams(String first, String second, Long third);
    void updateUser(User entity);
}
