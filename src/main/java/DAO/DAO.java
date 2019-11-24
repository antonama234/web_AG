package DAO;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();
    void add(T entity);
    void delete(T entity);
    T findById(Long id);
    T findByParams(String first, String second, Long third);
    void updateUser(T entity);
}
