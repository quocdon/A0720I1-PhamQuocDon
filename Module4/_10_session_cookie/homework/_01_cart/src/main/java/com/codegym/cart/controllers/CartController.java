package com.codegym.cart.controllers;

import com.codegym.cart.models.Item;
import com.codegym.cart.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    ItemService itemService;

    @GetMapping("/")
    public String showHomePage(@ModelAttribute("cart") Map<Item, Integer> cart, Model model){
        if ()
    }
}
