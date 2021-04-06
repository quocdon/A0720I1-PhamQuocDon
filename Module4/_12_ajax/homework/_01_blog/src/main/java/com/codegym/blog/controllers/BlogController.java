package com.codegym.blog.controllers;

import com.codegym.blog.models.Blog;
import com.codegym.blog.services.BlogService;
import com.codegym.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView model = new ModelAndView("create");
        model.addObject("blog", new Blog());
        model.addObject("categories", categoryService.findAll());
        return model;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog) {
        if (blog.getId() == 0) {
            blog.setCreatedTime(LocalDate.now());
        }
        Blog lastBlog = blogService.save(blog);
        return "redirect:/" + lastBlog.getId() + "/view";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("view", "blog", blogService.findById(id));
    }

    @GetMapping(value = {"/", "/{sortDirection}"})
    public ModelAndView sortedList(@PathVariable(required = false) String sortDirection,
                                   @RequestParam(defaultValue = "0") int page) {
        sortDirection = sortDirection == null ? "desc" : sortDirection;
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by("createdTime").ascending() : Sort.by("createdTime").descending();
        Pageable pageable = PageRequest.of(page, 5, sort);
        ModelAndView model = new ModelAndView("list");
        model.addObject("blogs", blogService.findAll(pageable));
        model.addObject("categories", categoryService.findAll());
        model.addObject("currentURI", "");
        return model;
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        blogService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @GetMapping({"/category/{id}"})
    public ModelAndView filterByCategory(@PathVariable int id, @PageableDefault(size = 5) Pageable pageable) {
        ModelAndView model = new ModelAndView("list");
        Page<Blog> blogPage = blogService.findAllByCategory(id, pageable);
        model.addObject("blogs", blogPage);
        model.addObject("categories", categoryService.findAll());
        model.addObject("currentURI", "/category/" + id);
        return model;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestBody String search, @PageableDefault(size = 5) Pageable pageable, Model model) {
        if (search.equals("")){
            model.addAttribute("blogs", blogService.findAll(pageable));
        } else {
            model.addAttribute("blogs", blogService.findBlogsByTitleContainsOrContentContains(search, search, pageable));
        }
        return "result";
    }
    @GetMapping("/search")
    public String showSearchPage(){
        return "search";
    }
}
