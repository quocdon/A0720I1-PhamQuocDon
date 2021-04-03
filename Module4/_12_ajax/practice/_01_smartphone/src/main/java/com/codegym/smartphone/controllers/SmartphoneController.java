package com.codegym.smartphone.controllers;

import com.codegym.smartphone.models.Smartphone;
import com.codegym.smartphone.services.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/smartphones")
public class SmartphoneController {
    @Autowired
    SmartphoneService smartphoneService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createSmartphonePage(){
        return new ModelAndView("phones/new-phone", "sPhone", new Smartphone());
    }

    @RequestMapping(value = "/createNewPhone", method = RequestMethod.POST,
    produces ={"application/json"}, consumes={"application/json"})
    @ResponseBody
    public Smartphone createSmartphone(@RequestBody Smartphone smartphone){
        return smartphoneService.save(smartphone);
    }
}
