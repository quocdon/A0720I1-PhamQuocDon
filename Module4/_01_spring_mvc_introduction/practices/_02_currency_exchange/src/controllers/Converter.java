package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
public class Converter {
    @RequestMapping(value = "/currency")
    public ModelAndView getHomePage(){
        return new ModelAndView("converter");
    }
    @RequestMapping(value = "/result")
    public String convert(@RequestParam float usd, Model model){
        float vnd = usd * 23000;
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);
        return "result";
    }
}
