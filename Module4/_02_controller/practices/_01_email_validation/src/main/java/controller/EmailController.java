package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    private static final String regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    private boolean validate(String email){
        return email.matches(regex);
    }

    @GetMapping("/")
    String getIndex(){
        return "index";
    }

    @PostMapping("/validate")
    String validateEmail(@RequestParam String email, Model model){
        boolean isValid = this.validate(email);
        if (!isValid){
            model.addAttribute("email", "email is invalid");
            return "index";
        }
        model.addAttribute("email", email);
        return "success";
    }
}
