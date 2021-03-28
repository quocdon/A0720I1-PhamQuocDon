package com.codegym.furama_resort.controllers;

import com.codegym.furama_resort.models.User;
import com.codegym.furama_resort.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class MainController {
    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public User getUser(){
        return new User();
    }

    @GetMapping("/")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, BindingResult bindingResult, @RequestParam("remember") boolean remember, Model model){
        if (!userService.existById(user.getUsername())){
            bindingResult.addError(new FieldError("user", "username", "Tên đăng nhập không tồn tại"));
            return "login";
        } else {
            if (userService.findByUsername(user.getUsername()).getPassword().equals(user.getPassword())){
                user = userService.findByUsername(user.getUsername());
                model.addAttribute("user", user);
                return "index";
            } else {
                bindingResult.addError(new FieldError("user", "password", "Mật khẩu không chính xác"));
                return "login";
            }
        }
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status){
        status.setComplete();
        return "redirect:/";
//        Edit after learning Spring security lesson
    }

    @ExceptionHandler(Exception.class)
    public String viewErrorPage(){
        return "error-page";
    }


}
