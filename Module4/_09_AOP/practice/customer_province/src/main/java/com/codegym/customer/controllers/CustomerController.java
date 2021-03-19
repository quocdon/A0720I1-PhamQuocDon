package com.codegym.customer.controllers;

import com.codegym.customer.models.Customer;
import com.codegym.customer.models.Province;
import com.codegym.customer.services.CustomerService;
import com.codegym.customer.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public List<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping("/customers")
    public String showCustomerList(@PageableDefault(size = 5) Pageable pageable, Model model){
        model.addAttribute("customers", customerService.findAll(pageable));
        return "customer/list";
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateCustomerForm(){
        return new ModelAndView("customer/create", "customer", new Customer());
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute Customer customer){
        ModelAndView modelAndView = new ModelAndView("customer/create");
        customerService.save(customer);
        modelAndView.addObject("message", "New customer created successfully");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        Customer customer = customerService.findById(id);
        if (customer != null){
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");

        }
    }
    @PostMapping("edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute Customer customer){
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        customerService.save(customer);
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "Customer update successfully");
        return modelAndView;

    }
}
