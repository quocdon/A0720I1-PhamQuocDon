package com.codegym.modal.services;

import com.codegym.modal.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> findAll();
    void save(Student student);
}
