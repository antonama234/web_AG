package DAO;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOJDBC implements UserDAO {
    private static UserDAOJDBC instance;
    private Connection connection;

    private UserDAOJDBC(Connection connection) {
        this.connection = connection;
    }

    public static UserDAOJDBC getInstance(Connection connection) {
        if (instance == null) {
            instance = new UserDAOJDBC(connection);
        }
        return instance;
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            statement.execute("SELECT * FROM users");
            ResultSet result = statement.getResultSet();
            while (result.next()) {
                User user = new User();
                user.setName(result.getString("name"));
                user.setSurName(result.getString("surName"));
                user.setAge(result.getLong("age"));
                list.add(user);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(User user) {
        try(PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, surName, age) values (?, ?, ?)")) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurName());
            statement.setLong(3, user.getAge());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try(Statement statement = connection.createStatement()) {
            Long id = user.getId();
            statement.executeUpdate("DELETE * FROM users WHERE id = '" + id + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findByLogin(String login) {
        User user = null;
        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login = ?")) {
            statement.setString(1, login);
            ResultSet result = statement.executeQuery();
            result.next();
            user = new User(
                    result.getString("name"),
                    result.getString("surName"),
                    result.getLong("age"));
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findById(Long id) {
        User user = null;
        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            user = new User(
                    result.getString("name"),
                    result.getString("surName"),
                    result.getLong("age"));
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByParams(String name, String surName, Long age) {
        User user  = null;
        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE name = ? AND surName = ? AND age = ?")) {
            statement.setString(1, name);
            statement.setString(2, surName);
            statement.setLong(3, age);
            ResultSet result = statement.executeQuery();
            result.next();
            user = new User(
                    result.getString("name"),
                    result.getString("surName"),
                    result.getLong("age"));
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        try(PreparedStatement statement = connection.prepareStatement("UPDATE users SET name = ?, surName = ?, age = ? WHERE id = ?")) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurName());
            statement.setLong(3, user.getAge());
            statement.setLong(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}