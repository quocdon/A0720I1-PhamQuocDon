package vn.codegym.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Student;

import java.util.List;


public interface StudentService {
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable);

    void save(Student student);
    void update(Student student);
    Student findById(int id);

    Page<Student> findByInputText(String inputSearch, Pageable pageable);
}
