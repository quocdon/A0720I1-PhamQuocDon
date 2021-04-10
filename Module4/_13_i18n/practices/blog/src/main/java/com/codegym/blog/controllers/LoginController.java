package com.codegym.blog.controllers;

import com.codegym.blog.models.Credential;
import com.codegym.blog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public User user(){
        return new User();
    }
    @GetMapping("/login")
    public String login(@ModelAttribute("credential")Credential credential, Model model){
        return "login";
    }

    @PostMapping("/login")
    public String dashboard(@ModelAttribute("credential") Credential credential, @ModelAttribute User user, Model model){
        user.setUsername(credential.getUsername());
        return "redirect:/dashboard";
    }
}