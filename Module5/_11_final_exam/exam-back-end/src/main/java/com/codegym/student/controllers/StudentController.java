package com.codegym.student.controllers;

import com.codegym.student.models.Student;
import com.codegym.student.servcies.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    private ResponseEntity<List<Student>> getStudentList(){
        List<Student> students = studentService.getAll();
        if (students.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}")
    private ResponseEntity<Student> getStudentById(@PathVariable int id){
        Student student = studentService.findById(id);
        if (student == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    private ResponseEntity<Student> editStudent(@RequestBody Student student){
        Student editedStudent = studentService.save(student);
        return new ResponseEntity<>(editedStudent, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    private ResponseEntity<?> deleteStudent(@PathVariable int id){
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
