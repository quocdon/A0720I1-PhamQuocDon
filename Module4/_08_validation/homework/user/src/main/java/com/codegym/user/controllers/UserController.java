package com.codegym.user.controllers;

import com.codegym.user.models.User;
import com.sun.java.swing.plaf.windows.WindowsDesktopIconUI;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/")
    public String viewForm(Model model){
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute User user, Model model, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "index";
        }
        model.addAttribute("user", user);
        model.addAttribute("message","Register successfully");
        return "result";
    }
}
