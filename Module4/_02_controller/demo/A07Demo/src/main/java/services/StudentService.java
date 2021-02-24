package services;

import models.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    void saveStudent(Student student);
}
