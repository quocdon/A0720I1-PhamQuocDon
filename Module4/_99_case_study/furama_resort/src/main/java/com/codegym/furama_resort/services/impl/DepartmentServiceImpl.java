package com.codegym.furama_resort.services.impl;

import com.codegym.furama_resort.models.Department;
import com.codegym.furama_resort.repositories.DepartmentRepository;
import com.codegym.furama_resort.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }
}
