package service.employee.dto.impl;

import model.Employee;
import model.dto.EmployeeDTO;
import service.employee.DepartmentService;
import service.employee.EducationDegreeService;
import service.employee.EmployeeService;
import service.employee.PositionService;
import service.employee.dto.EmployeeDTOService;
import service.employee.impl.DepartmentServiceImpl;
import service.employee.impl.EducationDegreeServiceImpl;
import service.employee.impl.EmployeeServiceImpl;
import service.employee.impl.PositionServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDTOServiceImpl implements EmployeeDTOService {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private PositionService positionService = new PositionServiceImpl();
    private EducationDegreeService educationDegreeService = new EducationDegreeServiceImpl();
    private DepartmentService departmentService = new DepartmentServiceImpl();
    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> employeeList = employeeService.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeList){
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setName(employee.getName());
            employeeDTO.setBirthday(employee.getBirthday());
            employeeDTO.setIdCard(employee.getIdCard());
            employeeDTO.setSalary(employee.getSalary());
            employeeDTO.setPhone(employee.getPhone());
            employeeDTO.setEmail(employee.getEmail());
            employeeDTO.setAddress(employee.getAddress());
            employeeDTO.setPositionId(employee.getPositionId());
            employeeDTO.setPositionName(positionService.getPositionById(employee.getPositionId()).getName());
            employeeDTO.setEducationDegreeId(employee.getEducationDegreeId());
            employeeDTO.setEducationDegreeName(educationDegreeService.getEducationDegreeById(employee.getEducationDegreeId()).getName());
            employeeDTO.setDepartmentId(employee.getDepartmentId());
            employeeDTO.setDepartmentName(departmentService.getDepartmentById(employee.getDepartmentId()).getName());
            employeeDTO.setUsername(employee.getUsername());
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    @Override
    public EmployeeDTO getById(int id) {
        List<EmployeeDTO> employeeDTOList = this.findAll();
        for (EmployeeDTO employeeDTO: employeeDTOList){
            if (employeeDTO.getId() == id){
                return employeeDTO;
            }
        }
        return null;
    }

    @Override
    public List<EmployeeDTO> getByName(String name) {
        List<EmployeeDTO> result = new ArrayList<>();
        List<EmployeeDTO> employeeDTOList = this.findAll();
        for (EmployeeDTO employeeDTO : employeeDTOList){
            if (employeeDTO.getName().equals(name)){
                result.add(employeeDTO);
            }
        }
        return result;
    }
}
