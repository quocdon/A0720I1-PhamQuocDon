package com.codegym.demospringjpa.services;

import com.codegym.demospringjpa.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface StudentService {
    Page<Student> findAll(Pageable pageable);
    void save(Student student);
    void delete(int id);
    Student findById(int id);
}
