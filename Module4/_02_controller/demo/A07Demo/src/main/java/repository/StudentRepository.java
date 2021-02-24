package repository;

import models.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudent();
    void saveStudent(Student student);
}
