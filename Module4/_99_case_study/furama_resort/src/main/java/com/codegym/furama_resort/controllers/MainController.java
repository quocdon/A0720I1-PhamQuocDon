package com.codegym.furama_resort.controllers;

import com.codegym.furama_resort.models.User;
import com.codegym.furama_resort.services.EmployeeService;
import com.codegym.furama_resort.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class MainController {
    @Autowired
    UserService userService;

    @Autowired
    EmployeeService employeeService;

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @GetMapping("/")
    public String viewHomePage(@ModelAttribute("user") User user) {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()){
            if (!userService.existById(user.getUsername())) {
                bindingResult.addError(new FieldError("user", "username", "Tên đăng nhập không tồn tại"));
            } else if (!userService.findByUsername(user.getUsername()).getPassword().equals(user.getPassword())) {
                bindingResult.addError(new FieldError("user", "password", "Mật khẩu không chính xác"));
            }
        }
        if (bindingResult.hasErrors()) {
            return "login";
        } else {
            user.setEmployee(employeeService.findByUsername(user.getUsername()));
            return "redirect:/";
        }
    }


    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
//        Edit after learning Spring security lesson
    }

    @ExceptionHandler(Exception.class)
    public String viewErrorPage() {
        return "error-page";
    }


}
