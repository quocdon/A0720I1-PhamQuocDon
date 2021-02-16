package dao.employee.impl;

import dao.employee.EmployeeDAO;
import model.Employee;
import utils.DBConnection;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id = ?";
    private static final String INSERT_EMPLOYEE = "insert into employee(employee_name, employee_birthday, employee_idcard, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, department_id, username) values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_EMPLOYEE = "delete from employee where employee_id = ?";
    private static final String UPDATE_EMPLOYEE = "update employee set employee_name = ?, employee_birthday = ?, employee_idcard = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?, department_id = ? where employee_id = ?";
    @Override
    public List<Employee> selectAll() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("employee_id");
            String name = resultSet.getNString("employee_name");
            Date birthday = resultSet.getDate("employee_birthday");
            String idCard = resultSet.getString("employee_idCard");
            double salary = resultSet.getDouble("employee_salary");
            String phone = resultSet.getString("employee_phone");
            String email = resultSet.getString("employee_email");
            String address = resultSet.getNString("employee_address");
            int positionId = resultSet.getInt("position_id");
            int educationDegreeId = resultSet.getInt("education_degree_id");
            int departmentId = resultSet.getInt("department_id");
            String username = resultSet.getString("username");
            employeeList.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, departmentId, username));
        }

        return employeeList;
    }

    @Override
    public Employee selectEmployeeById(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            String name = resultSet.getNString("employee_name");
            Date birthday = resultSet.getDate("employee_birthday");
            String idCard = resultSet.getString("employee_idcard");
            double salary = resultSet.getDouble("employee_salary");
            String phone = resultSet.getString("employee_phone");
            String email = resultSet.getString("employee_email");
            String address = resultSet.getNString("employee_address");
            int positionId = resultSet.getInt("position_id");
            int educationDegreeId = resultSet.getInt("education_degree_id");
            int departmentId = resultSet.getInt("department_id");
            String username = resultSet.getString("username");
            Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, departmentId, username);
            return employee;
        }
        return null;
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        Connection connection = DBConnection.getConnection();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = simpleDateFormat.format(employee.getBirthday());
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
        preparedStatement.setNString(1, employee.getName());
        preparedStatement.setString(2, birthday);
        preparedStatement.setString(3, employee.getIdCard());
        preparedStatement.setDouble(4, employee.getSalary());
        preparedStatement.setString(5, employee.getPhone());
        preparedStatement.setString(6, employee.getEmail());
        preparedStatement.setNString(7, employee.getAddress());
        preparedStatement.setInt(8, employee.getPositionId());
        preparedStatement.setInt(9, employee.getEducationDegreeId());
        preparedStatement.setInt(10, employee.getDepartmentId());
        preparedStatement.setString(11, employee.getUsername());
        preparedStatement.executeUpdate();
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        Connection connection = DBConnection.getConnection();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = simpleDateFormat.format(employee.getBirthday());
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
        preparedStatement.setNString(1, employee.getName());
        preparedStatement.setString(2, birthday);
        preparedStatement.setString(3, employee.getIdCard());
        preparedStatement.setDouble(4, employee.getSalary());
        preparedStatement.setString(5, employee.getPhone());
        preparedStatement.setString(6, employee.getEmail());
        preparedStatement.setNString(7, employee.getAddress());
        preparedStatement.setInt(8, employee.getPositionId());
        preparedStatement.setInt(9, employee.getEducationDegreeId());
        preparedStatement.setInt(10, employee.getDepartmentId());
        preparedStatement.setInt(11, employee.getId());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public List<Employee> selectEmployeeByName(String name) throws SQLException {
        List<Employee> employeeList = this.selectAll();
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employeeList){
            if (employee.getName().equals(name)){
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public List<Employee> selectEmployeePage(int page, int rowsPerPage, List<Employee> employeeList) {
        List<Employee> employeePage = new ArrayList<>();
        int i = (page-1)*rowsPerPage;
        while (i < page * 10 || i < employeeList.size()){
            employeePage.add(employeeList.get(i));
            i++;
        }
        return employeePage;
    }
}
