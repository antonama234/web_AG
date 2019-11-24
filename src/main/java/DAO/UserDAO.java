package DAO;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO implements DAO<User> {
    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    @Override
    public List<User> getAll() {
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public void add(User user) {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public User findById(Long id) {
        Transaction transaction = session.beginTransaction();
        User user = (User) session.createQuery("FROM User WHERE id=:id")
                .setParameter("id", id)
                .uniqueResult();
        transaction.commit();
        session.close();
        return user;
    }
    @Override
    public User findByParams(String name, String surName, Long age) {
        Transaction transaction = session.beginTransaction();
        User user = (User) session.createQuery("FROM User WHERE name=:name AND SurName=:surName AND age=:age")
                .setParameter("name", name)
                .setParameter("surName", surName)
                .setParameter("age", age)
                .uniqueResult();
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public void updateUser(User user) {
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }
}
