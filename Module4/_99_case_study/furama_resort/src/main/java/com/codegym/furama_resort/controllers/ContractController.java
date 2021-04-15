package com.codegym.furama_resort.controllers;

import com.codegym.furama_resort.models.*;
import com.codegym.furama_resort.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @GetMapping("/")
    public String contractList(@RequestParam(defaultValue = "") String search, @RequestParam (defaultValue = "0") int page, Model model){
        Pageable pageable = PageRequest.of(page, 5);
        if (search.equals("")){
            model.addAttribute("contracts", contractService.findAll(pageable));
        }
        return "/contract/list";
    }
}
