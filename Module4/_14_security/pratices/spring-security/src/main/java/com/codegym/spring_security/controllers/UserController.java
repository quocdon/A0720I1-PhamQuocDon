package com.codegym.spring_security.controllers;

import com.codegym.spring_security.models.AppRole;
import com.codegym.spring_security.models.AppUser;
import com.codegym.spring_security.models.AppUserDto;
import com.codegym.spring_security.models.UserRole;
import com.codegym.spring_security.repositories.UserRepository;
import com.codegym.spring_security.services.RoleService;
import com.codegym.spring_security.services.UserDetailsServiceImpl;
import com.codegym.spring_security.services.UserRoleService;
import com.codegym.spring_security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userDto", new AppUserDto());
        model.addAttribute("roles", roleService.findAll());
        return "register";
    }

    @PostMapping("/register")
    @Transactional
    public String registerNewUser(@ModelAttribute(name = "userDto") AppUserDto userDto, Model model) {
        if (userService.findByUsername(userDto.getUsername()) != null){
            model.addAttribute("usernameMessage", "Username is exist already");
            model.addAttribute("appRoles", roleService.findAll());
            return "register";
        }

        if (!userDto.getPassword().equals(userDto.getConfirmPassword())){
            model.addAttribute("passwordMessage", "Password is not matched");
            return "register";
        }

        AppUser appUser = new AppUser();
        appUser.setUsername(userDto.getUsername());
        appUser.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        AppUser newAppUser = userService.save(appUser);
//        for(AppRole role : userDto.getAppRoles()){
//            UserRole userRole = new UserRole();
//            userRole.setUser(newAppUser);
//            userRole.setRole(role);
//            userRoleService.save(userRole);
//            newAppUser.getUserRoles().add(userRole);
//        }
//        userService.save(newAppUser);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/user")
    public String userPage(Model model, Principal principal){
        String username = principal.getName();
        User loggedInUser = (User) ((Authentication)principal).getPrincipal();
        model.addAttribute("loggedInUser", loggedInUser);
        return "userInfo";
    }

    @GetMapping("/admin")
    public String adminPage(Model model, Principal principal){
        String username = principal.getName();
        User loggedInUser = (User) ((Authentication)principal).getPrincipal();
        model.addAttribute("loggedInUser", loggedInUser);
        return "admin";
    }
}
