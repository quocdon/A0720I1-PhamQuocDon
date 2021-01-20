package dao.impl;

import dao.UserDAO;
import models.User;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final String SELECT_ALL_USER = "Select * from users";
    @Override
    public List<User> getAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String user = resultSet.getString("user");
            String password = resultSet.getString("password");
            userList.add(new User(user, password));
        }
        return userList;
    }

    @Override
    public User getUser(String username) throws SQLException {
        List<User> userList = this.getAll();
        for (User user : userList){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean checkUsername(String username) throws SQLException {
        if (this.getUser(username) != null){
            return false;
        }
        return true;
    }

    @Override
    public void insertUser(User user) {

    }
}
