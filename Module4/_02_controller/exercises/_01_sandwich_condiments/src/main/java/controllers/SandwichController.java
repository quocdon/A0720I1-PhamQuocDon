package controllers;

import model.Sandwich;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @GetMapping("/")
    public ModelAndView getHompage(){
        return new ModelAndView("index", "sandwich", new Sandwich());
    }

    @PostMapping("/sandwich")
    String showCondiments(@ModelAttribute Sandwich sandwich, Model model){
            model.addAttribute("sandwich", sandwich);
        return "condiments";
    }
}
