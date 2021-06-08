package com.codegym.student.controllers;

import com.codegym.student.models.Teacher;
import com.codegym.student.servcies.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> getTeacherList(){
        List<Teacher> teachers = teacherService.getAll();
        if (teachers.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }
    @GetMapping("/teachers/{id}")
    public ResponseEntity<Teacher> getTeacherList(@PathVariable int id){
        Teacher teacher = teacherService.findById(id);
        if (teacher == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }
}
