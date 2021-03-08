package com.codegym.demospringjpa.controllers;

import com.codegym.demospringjpa.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public ModelAndView getStudentList(){
        return new ModelAndView("list", "students", studentService.findAll());
    }
}
