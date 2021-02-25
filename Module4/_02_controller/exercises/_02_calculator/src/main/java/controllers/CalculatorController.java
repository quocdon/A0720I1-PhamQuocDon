package controllers;

import models.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String getHompage() {
        return "index";
    }

    @PostMapping("/result")
    public String getResult(@RequestParam double number1, @RequestParam double number2, @RequestParam String operator, Model model) throws Exception {
        Calculator calculator = new Calculator(number1, number2, operator);
        if (number2 == 0 && operator.equals("Division")) {
            model.addAttribute("error", "divide by zero");
            return "index";
        } else {
            model.addAttribute("calcuator", calculator);
            return "result";
        }
    }
    @ExceptionHandler(Exception.class)
    public String handleException(Model model){
        model.addAttribute("error", "Only input number");
        return "index";
    }
}
