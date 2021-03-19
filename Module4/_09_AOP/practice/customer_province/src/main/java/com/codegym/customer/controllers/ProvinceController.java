package com.codegym.customer.controllers;

import com.codegym.customer.models.Province;
import com.codegym.customer.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ProvinceController {
    @Autowired
    ProvinceService provinceService;
    @GetMapping("/provinces")
    public String showProvinceList(Model model){
        model.addAttribute("provinces", provinceService.findAll());
        return "province/list";
    }

    @GetMapping("create-province")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("create-province")
    public ModelAndView saveProvince(@ModelAttribute Province province){
        ModelAndView modelAndView = new ModelAndView("province/create");
        provinceService.save(province);
        modelAndView.addObject("message", "New province created successfully");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }


}
