package com.codegym.demoaop.controller;

import com.codegym.demoaop.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @Autowired
    Hello hello;

    @GetMapping("")
    public String testAOP(Model model) {
        model.addAttribute("message", hello.getMessage());
        hello.method1();
        hello.method2();
        hello.method3();
        return "index";
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public String showErrorPage(){
        return "error";
    }
}
