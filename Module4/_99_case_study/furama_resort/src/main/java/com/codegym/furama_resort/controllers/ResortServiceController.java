package com.codegym.furama_resort.controllers;

import com.codegym.furama_resort.models.ResortService;
import com.codegym.furama_resort.services.RentTypeService;
import com.codegym.furama_resort.services.ResortServiceService;
import com.codegym.furama_resort.services.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/service")
public class ResortServiceController {
    @Autowired
    private ResortServiceService resortServiceService;

    @Autowired
    private RentTypeService rentTypeService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("resort_services/create");
        modelAndView.addObject("resortService", new ResortService());
        modelAndView.addObject("rentTypes", rentTypeService.findAll());
        modelAndView.addObject("serviceTypes", serviceTypeService.findAll());
        return modelAndView;
    }
}
