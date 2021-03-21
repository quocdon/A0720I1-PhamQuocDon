package com.codegym.furama_resort.repositories;

import com.codegym.furama_resort.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findEmployeesByNameContains(String name, Pageable pageable);
}
