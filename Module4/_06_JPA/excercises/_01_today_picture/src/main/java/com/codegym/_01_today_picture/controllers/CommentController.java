package com.codegym._01_today_picture.controllers;

import com.codegym._01_today_picture.Services.CommentService;
import com.codegym._01_today_picture.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/")
    public ModelAndView viewHomePage() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("comments", commentService.findAll());
        modelAndView.addObject("comment", new Comment());
        modelAndView.addObject("ratingList", new int[]{1, 2, 3, 4, 5});
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveComment(@ModelAttribute Comment comment){
        commentService.save(comment);
        return "redirect:/";
    }

    @GetMapping("/{id}/like")
    public String likeComment(@PathVariable int id){
        commentService.reactComment(id);
        return "redirect:/";
    }
}
