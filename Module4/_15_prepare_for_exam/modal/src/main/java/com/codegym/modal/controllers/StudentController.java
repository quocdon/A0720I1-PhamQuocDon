package com.codegym.modal.controllers;

import com.codegym.modal.models.Student;
import com.codegym.modal.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/")
    public String view(Model model){
        model.addAttribute("students", studentService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute Student student, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            return "create";
        }
        return "redirect:/";
    }
}
