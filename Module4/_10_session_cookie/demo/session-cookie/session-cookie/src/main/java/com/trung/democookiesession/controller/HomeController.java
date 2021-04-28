package com.trung.democookiesession.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/createCookie")
    public String createCookie(HttpServletResponse response, Model model) {
        Cookie cookie1 = new Cookie("userName1", "TrungDoan1");
        Cookie cookie2 = new Cookie("userName2", "TrungDoan2");
        Cookie cookie3 = new Cookie("userName3", "TrungDoan3");
        cookie1.setMaxAge(60);
        cookie2.setMaxAge(60);
        cookie3.setMaxAge(60);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        return "home";
    }

    @GetMapping("/getCookie")
    public String getCookiePage(@CookieValue(name = "userName")String userName, Model model){
        model.addAttribute("userName", userName);
        return "getCookie";
    }
    @GetMapping("/updateCookie")
    public String updateCookiePage(){
        return "updateCookie";
    }

    @PostMapping("updateCookie")
    public String updateCookie(@RequestParam String userName, HttpServletResponse response){
        Cookie cookie = new Cookie("userName", userName);
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        return "home";
    }

    @GetMapping("/deleteCookie")
    public String delete(@CookieValue(name = "userName")String userName, HttpServletResponse response){
        Cookie cookie = new Cookie("userName", userName);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "home";
    }
}
