package com.codegym.student.servcies;

import com.codegym.student.models.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    List<Teacher> getAll();
    Teacher findById(int id);
}
