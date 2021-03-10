package com.codegym.blog.controllers;

import com.codegym.blog.models.Blog;
import com.codegym.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView model = new ModelAndView("create");
        model.addObject("blog", new Blog());
        model.addObject("category", categoryService.findAll());
        return model;
    }
}
