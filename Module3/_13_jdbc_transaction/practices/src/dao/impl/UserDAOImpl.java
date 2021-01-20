package dao.impl;

import dao.IUserDAO;
import model.User;
import ultils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    private static final String INSERT_USER_SQL = "insert into User(id, name, email, country) values (?, ?, ?, ?)";
    private static final String SELECT_USER_BY_ID_SQL = "select * from user where id = ?";
    private static final String SELECT_ALL_USER_SQL = "select * from user";
    private static final String DELETE_USER_BY_ID_SQL = "delete from user where id = ?";
    private static final String UPDATE_USER_SQL = "update user set name = ?, email = ?, country = ? where id = ?";
    private static final String SELECT_USER_BY_NAME_SQL = "select * from user where user.name like ?";

    @Override
    public void insertUser(User user) throws SQLException {
        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getCountry());

        preparedStatement.executeUpdate();
    }

    @Override
    public User selectUser(int id) throws SQLException {
        User user = null;
        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID_SQL);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");
            user = new User(id, name, email, country);
        }

        return user;
    }

    @Override
    public List<User> selectAllUser() throws SQLException {
        List<User> userList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER_SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");
            userList.add(new User(id, name, email, country));
        }
        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID_SQL);
        preparedStatement.setInt(1, id);

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL);

        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getCountry());
        preparedStatement.setInt(4, user.getId());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public List<User> selectByName(String searchName) throws SQLException {
        List<User> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_NAME_SQL);

        preparedStatement.setString(1, "%" + searchName + "%");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");
            list.add(new User(id, name, email, country));
        }
        return list;
    }

    @Override
    public User getUserById(int id) throws SQLException {
        User user = null;
        String querry = "{CALL get_user_by_id(?)}";
        Connection connection = DBConnection.getConnection();
        CallableStatement callableStatement = connection.prepareCall(querry);
        callableStatement.setInt(1, id);
        ResultSet resultSet = callableStatement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");
            user = new User(id, name, email, country);
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String querry = "{CALL insert_user(?,?,?)}";
        Connection connection = DBConnection.getConnection();
        CallableStatement callableStatement = connection.prepareCall(querry);
        callableStatement.setString(1, user.getName());
        callableStatement.setString(2, user.getEmail());
        callableStatement.setString(3, user.getCountry());
        callableStatement.executeUpdate();
    }
}
