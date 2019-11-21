package DAO;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();
    void add(T entity);
    void delete(T entity);
    T findById(Long id);
    void updateUser(T entity);
}
