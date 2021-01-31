package service.employee;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User getUser(String username);
    void save(User user);
    boolean delete(String username);
    boolean checkUser(String username, String password);
}
