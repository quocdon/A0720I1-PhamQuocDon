package com.codegym.furama_resort.repositories;

import com.codegym.furama_resort.models.Employee;
import com.codegym.furama_resort.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findEmployeesByNameContains(String name, Pageable pageable);
    @Query("SELECT e FROM Employee e WHERE e.user.username = :username")
    Employee findAllByUsername(@Param("username") String username);
}
