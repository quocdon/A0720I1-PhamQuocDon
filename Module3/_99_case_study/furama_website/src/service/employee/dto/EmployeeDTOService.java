package service.employee.dto;

import model.Employee;
import model.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeDTOService {
    List<EmployeeDTO> findAll();
    EmployeeDTO getById(int id);
    List<EmployeeDTO> getByName(String name);
    public List<EmployeeDTO> selectEmployeePage(int page, int rowsPerPage, List<EmployeeDTO> employeeList);
}
