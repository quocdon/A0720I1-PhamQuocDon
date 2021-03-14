package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    List<Department> findAll();

    Department findById(int id);
}
