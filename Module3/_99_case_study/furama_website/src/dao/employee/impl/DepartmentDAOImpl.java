package dao.employee.impl;

import dao.employee.DepartmentDAO;
import model.Department;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    private static final String SELECT_ALL = "Select * from department";
    private static final String SELECT_BY_ID = "Select * from department where department_id = ?";
    @Override
    public List<Department> selectAll() throws SQLException {
        List<Department> departmentList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("department_id");
            String name = resultSet.getString("department_name");
            Department department = new Department(id, name);
            departmentList.add(department);
        }
        return departmentList;
    }

    @Override
    public Department selectDepartmentById(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            String name = resultSet.getString("department_name");
            return new Department(id, name);
        }
        return null;
    }
}
