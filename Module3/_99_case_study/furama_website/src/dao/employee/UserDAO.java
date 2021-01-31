package dao.employee;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> selectAll() throws SQLException;
    User selectUser(String username) throws SQLException;
    void insertUser(User user) throws SQLException;
    boolean deleteUser(String username) throws SQLException;
}
