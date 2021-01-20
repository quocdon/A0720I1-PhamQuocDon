package dao;

import models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> getAll() throws SQLException;
    User getUser(String username) throws SQLException;
    boolean checkUsername(String username) throws SQLException;
    void insertUser(User user);
}
