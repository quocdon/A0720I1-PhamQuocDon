package com.codegym.blog.controllers;

import com.codegym.blog.models.AppUser;
import com.codegym.blog.models.Blog;
import com.codegym.blog.models.Category;
import com.codegym.blog.services.AppUserService;
import com.codegym.blog.services.BlogService;
import com.codegym.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;

    @Autowired
    AppUserService appUserService;

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return categoryService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView model = new ModelAndView("create");
        model.addObject("blog", new Blog());
        return model;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, Principal principal) {
        if (blog.getId() == 0) {
            blog.setCreatedTime(LocalDate.now());
        }
        if (blog.getAppUser() == null) {
            String username = principal.getName();
            AppUser appUser = appUserService.findByUsername(username);
            blog.setAppUser(appUser);
        }
        Blog lastBlog = blogService.save(blog);
        return "redirect:/view/" + lastBlog.getId();
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("view", "blog", blogService.findById(id));
    }


    @GetMapping(value = {"/"})
    public ModelAndView getBlogList(@RequestParam(defaultValue = "desc") String sortDirection,
                                    @RequestParam(defaultValue = "0") int categoryId,
                                    @RequestParam(defaultValue = "") String search,
                                    @RequestParam(defaultValue = "0") int page) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.DESC.name()) ? Sort.by("createdTime").descending() : Sort.by("createdTime").ascending();
        Pageable pageable = PageRequest.of(page, 5, sort);
        ModelAndView model = new ModelAndView("list");
        Page<Blog> blogs;
        if (categoryId != 0 && !search.equals("")) {
            blogs = blogService.findAllByTitleContainsAndCategory_Id(search, categoryId, pageable);
            model.addObject("search", search);
            model.addObject("categoryId", categoryId);
        } else {
            if (categoryId == 0 && !search.equals("")) {
                blogs = blogService.findAllByTitleContains(search, pageable);
                model.addObject("search", search);
            } else if (categoryId != 0) {
                blogs = blogService.findAllByCategory(categoryId, pageable);
                model.addObject("categoryId", categoryId);
            } else {
                blogs = blogService.findAll(pageable);
            }
        }
        model.addObject("blogs", blogs);
        model.addObject("sortDirection", sortDirection);
        return model;
    }


    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public ModelAndView sortedList(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "") String search) {
        int pageSize = 5;
        ModelAndView model = new ModelAndView("result");
        List<Blog> blogs = new ArrayList<>();
        if (search.equals("")) {
            for (int i = 0; i <= page; i++) {
                Pageable pageable = PageRequest.of(page, pageSize);
                blogs.addAll(blogService.findAll(pageable).getContent());
            }
            Pageable pageable = PageRequest.of(page + 1, pageSize);
            boolean more = blogService.findAll(pageable) != null;
            model.addObject("more", more);
        } else {
            for (int i = 0; i <= page; i++) {
                Pageable pageable = PageRequest.of(page, pageSize);
                blogs.addAll(blogService.findAllByTitleContains(search, pageable).getContent());
            }
            Pageable pageable = PageRequest.of(page + 1, pageSize);
            boolean more = blogService.findAllByTitleContains(search, pageable) != null;
            model.addObject("more", more);
        }
        model.addObject("search", search);
        model.addObject("page", page + 1);
        model.addObject("blogs", blogs);
        return model;
    }

    //Admin can edit or delete all blogs
    //Users can edit own blogs

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Principal principal) {
        Blog blog = blogService.findById(id);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        if (loginedUser.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")) || principal.getName().equals(blog.getAppUser().getUsername())) {
            blogService.delete(id);
            return "redirect:/";
        } else {
            return "redirect:/403";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model, Principal principal) {
        Blog blog = blogService.findById(id);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        if (loginedUser.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")) || principal.getName().equals(blog.getAppUser().getUsername())) {
            model.addAttribute("blog", blog);
            return "edit";
        } else {
            return "redirect:/403";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "403";
    }
}
