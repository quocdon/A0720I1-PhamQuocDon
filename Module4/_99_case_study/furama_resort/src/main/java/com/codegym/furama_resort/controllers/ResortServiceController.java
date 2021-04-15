package com.codegym.furama_resort.controllers;

import com.codegym.furama_resort.models.AppUser;
import com.codegym.furama_resort.models.ResortService;
import com.codegym.furama_resort.services.RentTypeService;
import com.codegym.furama_resort.services.ResortServiceService;
import com.codegym.furama_resort.services.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute ResortService resortService, BindingResult bindingResult, Model model) {
        if (resortServiceService.existById(resortService.getId())) {
            bindingResult.addError(new FieldError("resortService", "id", "Mã dịch vụ đã tồn tại"));
        }

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("rentTypes", rentTypeService.findAll());
            model.addAttribute("serviceTypes", serviceTypeService.findAll());
            return "resort_services/create";
        }
        resortServiceService.save(resortService);
        return "redirect:/service/";
    }

    @GetMapping(value = {"", "/"})
    public ModelAndView search(@RequestParam(defaultValue = "") String search, @RequestParam(defaultValue = "0") int page) {
        search = search.trim();
        ModelAndView modelAndView = new ModelAndView("resort_services/list");
        Pageable pageable = PageRequest.of(page, 5);
        if (search.equals("")) {
            modelAndView.addObject("services", resortServiceService.findAll(pageable));
        } else {
            modelAndView.addObject("search", search);
            modelAndView.addObject("services", resortServiceService.findByName(search, pageable));
        }
        return modelAndView;
    }

    @GetMapping("/serviceModal")
    public String showServiceListInModal(@RequestParam(defaultValue = "") String search,
                                         @RequestParam(defaultValue = "0") int page,
                                         Model model){
        Pageable pageable = PageRequest.of(page, 10);
        if (search.equals("")){
            model.addAttribute("services", resortServiceService.findAll(pageable));
        } else {
            model.addAttribute("search", search);
            model.addAttribute("services", resortServiceService.findByName(search, pageable));
        }
        return "/resort_services/listModal";
    }

    @ExceptionHandler(Exception.class)
    public String viewErrorPage(){
        return "error-page";
    }
}
