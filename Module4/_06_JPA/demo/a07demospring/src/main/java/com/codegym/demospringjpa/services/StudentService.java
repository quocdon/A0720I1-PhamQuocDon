package com.codegym.demospringjpa.services;

import com.codegym.demospringjpa.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void save(Student student);
    void delete(int id);
    Student findById(int id);
}
