package service.employee.impl;

import dao.employee.EmployeeDAO;
import dao.employee.impl.EmployeeDAOImpl;
import model.Employee;
import service.employee.EmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    @Override
    public List<Employee> findAll() {
        try {
            return employeeDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getById(int id) {
        try {
            return employeeDAO.selectEmployeeById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Employee employee) {
        try {
            employeeDAO.insertEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean remove(int id) {
        try {
            employeeDAO.deleteEmployee(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        try {
           return employeeDAO.updateEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employee> searchByName(String name) {
        try {
            return employeeDAO.selectEmployeeByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
