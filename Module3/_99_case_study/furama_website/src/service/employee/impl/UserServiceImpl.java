package service.employee.impl;

import dao.employee.UserDAO;
import dao.employee.impl.UserDAOImpl;
import model.User;
import service.employee.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDAO userDAO = new UserDAOImpl();
    @Override
    public List<User> findAll() {
        try {
            return userDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUser(String username){
        try {
            return userDAO.selectUser(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(User user){
        try {
            userDAO.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(String username) {
        try {
            return userDAO.deleteUser(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkUser(String username, String password) {
        User user = this.getUser(username);
        if (user == null || !user.getPassword().equals(password)){
            return false;
        }
        return true;
    }
}
