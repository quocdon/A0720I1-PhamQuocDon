package com.codegym.furama_resort.controllers;

import com.codegym.furama_resort.models.*;
import com.codegym.furama_resort.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("user")
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ResortServiceService resortServiceService;

    @Autowired
    ContractService contractService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomerService customerService;

    @Autowired
    AttachServiceService attachServiceService;

    @ModelAttribute("user")
    public User getUser(){
        return new User();
    }

    @ModelAttribute("employees")
    public List<Employee> getEmployeeList(){
        return employeeService.findAll();
    }

    @ModelAttribute("customers")
    public List<Customer> getCustomerList(){
        return customerService.findAll();
    }

    @ModelAttribute("attachServices")
    public List<AttachService> getAttachServiceList(){
        return attachServiceService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView viewCreateForm(@RequestParam (defaultValue = "") String serviceId){
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("service", resortServiceService.findById(serviceId));
        return modelAndView;
    }
}
