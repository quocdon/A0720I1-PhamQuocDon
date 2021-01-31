package service.employee.impl;

import dao.employee.DepartmentDAO;
import dao.employee.impl.DepartmentDAOImpl;
import model.Department;
import service.employee.DepartmentService;

import java.sql.SQLException;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();
    @Override
    public List<Department> findAll() {
        try {
           return departmentDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Department getDepartmentById(int id) {
        try {
          return  departmentDAO.selectDepartmentById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
