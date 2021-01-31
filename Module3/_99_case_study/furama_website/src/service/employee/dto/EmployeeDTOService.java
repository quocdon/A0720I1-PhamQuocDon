package service.employee.dto;

import model.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeDTOService {
    List<EmployeeDTO> findAll();
    EmployeeDTO getById(int id);
    List<EmployeeDTO> getByName(String name);
}
