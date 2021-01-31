package service.employee;

import model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee getById(int id);
    void save(Employee employee);
    boolean remove(int id);
    boolean update(Employee employee);
    List<Employee> searchByName(String name);
}
