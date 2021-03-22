package com.codegym.furama_resort.controllers;

import com.codegym.furama_resort.models.Contract;
import com.codegym.furama_resort.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
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

    @GetMapping("/create")
    public ModelAndView viewCreateForm(@RequestParam (defaultValue = "") String serviceId){
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("service", resortServiceService.findById(serviceId));
        modelAndView.addObject("employees", employeeService.findAll());
        modelAndView.addObject("customers", customerService.findAll());
        modelAndView.addObject("attachServices", attachServiceService.findAll());
        return modelAndView;
    }
}
