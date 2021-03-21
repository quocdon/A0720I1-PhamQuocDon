package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    Employee findById(int id);
    Employee save(Employee employee);
    void delete(int id);
    Page<Employee> findByName(String search, Pageable pageable);
}
