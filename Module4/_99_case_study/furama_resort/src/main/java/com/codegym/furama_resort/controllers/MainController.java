package com.codegym.furama_resort.controllers;

import com.codegym.furama_resort.models.AppUser;
import com.codegym.furama_resort.services.EmployeeService;
import com.codegym.furama_resort.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    AppUserService appUserService;

    @Autowired
    EmployeeService employeeService;

//    @ModelAttribute("searchUri")
//    public String getCurrentUri(HttpServletRequest request) {
//        return "@{/" + request.getRequestURI() + "}";
//    }

    @GetMapping("/")
    public String viewHomePage(@ModelAttribute("user") AppUser appUser) {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
//        Edit after learning Spring security lesson
    }

//    @ExceptionHandler(Exception.class)
//    public String viewErrorPage() {
//        return "error-page";
//    }


}
