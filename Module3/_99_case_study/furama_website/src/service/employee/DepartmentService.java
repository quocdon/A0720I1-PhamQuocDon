package service.employee;

import model.Department;
import model.Position;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
    Department getDepartmentById(int id);
}
