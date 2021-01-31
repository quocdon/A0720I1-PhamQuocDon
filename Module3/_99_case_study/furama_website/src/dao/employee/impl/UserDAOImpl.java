package dao.employee.impl;

import dao.employee.UserDAO;
import model.User;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final String SELECT_ALL = "Select * from user";
    private static final String SELECT_BY_USERNAME = "Select * from user where username = ?";
    private static final String INSERT_USER = "insert into user(username, password) values(?,?)";
    private static final String DELETE_USER = "delete from user where username = ?";
    private static final String UPDATE_USER = "delete from user where username = ?";
    @Override
    public List<User> selectAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            User user = new User(username, password);
            userList.add(user);
        }
        return userList;
    }

    @Override
    public User selectUser(String username) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_USERNAME);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            String password = resultSet.getString("password");
            return new User(username, password);
        }
        return null;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();
    }

    @Override
    public boolean deleteUser(String username) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
        preparedStatement.setString(1, username);
        return preparedStatement.executeUpdate() > 0;
    }
}
