package com.codegym.furama_resort.controllers;

import com.codegym.furama_resort.models.Customer;
import com.codegym.furama_resort.services.CustomerService;
import com.codegym.furama_resort.services.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, Model model) {
        if (customerService.existById(customer.getId())) {
            bindingResult.addError(new FieldError("customer", "id", "Mã khách hàng đã tồn tại"));
        }

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypes", customerTypeService.findAll());
            return "customer/create";
        }
        customerService.save(customer);
        return "redirect:/customer/";
    }
//
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        customerService.delete(id);
        return "redirect:/customer/";
    }
//
    @GetMapping("edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "customer/edit";
    }
//
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypes", customerTypeService.findAll());
            return "customer/edit";
        }
        customerService.save(customer);
        return "redirect:/customer/";
    }
//
    @GetMapping("/view/{id}")
    public String view(@PathVariable String id, Model model) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return "redirect:/customer/";
        } else {
            model.addAttribute("customer", customer);
            return "customer/view";
        }
    }

    @GetMapping(value = {"", "/"})
    public ModelAndView search(@RequestParam(defaultValue = "") String search, @RequestParam(defaultValue = "0") int page) {
        search = search.trim();
        ModelAndView modelAndView = new ModelAndView("customer/list");
        Pageable pageable = PageRequest.of(page, 5);
        if (search.equals("")) {
            modelAndView.addObject("customers", customerService.findAll(pageable));
            return modelAndView;
        } else {
            modelAndView.addObject("search", search);
            modelAndView.addObject("customers", customerService.findAllByIdOrName(search, pageable));
            return modelAndView;
        }
    }

    @ExceptionHandler(Exception.class)
    public String viewErrorPage(){
        return "error-page";
    }
}
