package com.codegym.furama_resort.repositories;

import com.codegym.furama_resort.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
