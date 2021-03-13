package com.codegym.demospringjpa.repositories;

import com.codegym.demospringjpa.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Page<Student> findAll(Pageable pagable);
}
