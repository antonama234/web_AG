package DAO;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOHibernate implements UserDAO {
    private static UserDAOHibernate instance;
    private SessionFactory sessionFactory;

    private UserDAOHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserDAOHibernate getInstance(SessionFactory sessionFactory) {
        if (instance == null) {
            instance = new UserDAOHibernate(sessionFactory);
        }
        return instance;
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public void add(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public User findById(Long id) {
        Session session = sessionFactory.openSession();
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
        Session session = sessionFactory.openSession();
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
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }
}
