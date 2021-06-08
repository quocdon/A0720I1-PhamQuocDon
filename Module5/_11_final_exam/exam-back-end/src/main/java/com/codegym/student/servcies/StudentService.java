package com.codegym.student.servcies;

import com.codegym.student.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAll();
    Student findById(int id);
    Student save(Student student);
    void delete(int id);
}
