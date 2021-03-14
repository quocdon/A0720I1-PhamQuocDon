package com.codegym.furama_resort.controllers;

import com.codegym.furama_resort.models.Employee;
import com.codegym.furama_resort.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    PositionService positionService;

    @Autowired
    EducationDegreeService educationDegreeService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView list(){
        Pageable pageable = PageRequest.of(0,5);
        return new ModelAndView("employeeList", "employees", employeeService.findAll(pageable));
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("employeeCreate");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("departments", departmentService.findAll());
        modelAndView.addObject("positions", positionService.findAll());
        modelAndView.addObject("educationDegrees", educationDegreeService.findAll());
        modelAndView.addObject("roles", roleService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee employee, Model model){
        employeeService.save(employee);
        return "redirect:/employee/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        employeeService.delete(id);
        return "redirect:/employee/";
    }
}
