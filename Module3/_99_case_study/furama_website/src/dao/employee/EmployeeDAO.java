package dao.employee;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> selectAll() throws SQLException;
    Employee selectEmployeeById(int id) throws SQLException;
    void insertEmployee(Employee employee) throws SQLException;
    boolean deleteEmployee(int id) throws SQLException;
    boolean updateEmployee(Employee employee) throws SQLException;
    List<Employee> selectEmployeeByName(String name) throws SQLException;
    List<Employee> selectEmployeePage(int page, int rowsOfPage, List<Employee> employeeList);
}
