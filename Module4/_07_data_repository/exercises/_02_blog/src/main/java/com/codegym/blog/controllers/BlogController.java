package com.codegym.blog.controllers;

import com.codegym.blog.models.Blog;
import com.codegym.blog.services.BlogService;
import com.codegym.blog.services.CategoryService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
public class BlogController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView model = new ModelAndView("create");
        model.addObject("blog", new Blog());
        model.addObject("categories", categoryService.findAll());
        return model;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog){
        blog.setCreatedTime(LocalDate.now());
        Blog lastBlog = blogService.save(blog);
        return "redirect:/" + lastBlog.getId() + "/view";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id){
        return new ModelAndView("view", "blog", blogService.findById(id));
    }

    @GetMapping("/")
    public ModelAndView list(@PageableDefault(size = 5)Pageable pageable){
        return new ModelAndView("list", "blogs", blogService.findAll(pageable));
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        blogService.delete(id);
        return "redirect:/";
    }
}
