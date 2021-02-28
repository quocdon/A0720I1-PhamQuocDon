package com.codegym.controllers;


import com.codegym.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/")
    public String getHompage() {
        return "index";
    }

    @PostMapping("/result")
    public String getResult(@RequestParam double number1, @RequestParam double number2, @RequestParam String operator, Model model) throws Exception {
        try {
            double result = calculatorService.calculate(number1, number2, operator);
            model.addAttribute("result", result);
            model.addAttribute("number1", number1);
            model.addAttribute("number2", number2);
            model.addAttribute("operator", operator);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "index";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Model model) {
        model.addAttribute("error", "Only input number");
        return "index";
    }
}
