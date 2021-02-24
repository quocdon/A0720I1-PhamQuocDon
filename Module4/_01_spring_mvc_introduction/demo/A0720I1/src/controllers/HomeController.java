package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getHomePage(){
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, Model model){
        if ("trungdoan".equals(username) && "123123".equals(password)){
            model.addAttribute("message", "Login success");
            return "result";
        }else {
            return "home";
        }



    }
}
