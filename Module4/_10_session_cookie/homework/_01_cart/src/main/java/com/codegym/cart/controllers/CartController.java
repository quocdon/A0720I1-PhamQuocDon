package com.codegym.cart.controllers;

import com.codegym.cart.models.Item;
import com.codegym.cart.services.ItemService;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    ItemService itemService;

    @ModelAttribute("cart")
    public Map<Item, Integer> setUpCart() {
        return new HashMap<>();
    }

    @GetMapping("/")
    public String showHomePage(Model model){
        model.addAttribute("items", itemService.findAll());
        return "index";
    }
    @GetMapping("/addCart")
    public String addCart(@ModelAttribute("cart") Map<Item, Integer> cart, Model model, @RequestParam int id, @RequestParam int quantity){
        Item item = itemService.findById(id);
        if (cart.containsKey(item)){
            cart.replace(item, cart.get(item), cart.get(item) + quantity);
        } else {
            cart.put(item, quantity);
        }
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String showCart(@ModelAttribute("cart") Map<Item, Integer> cart, Model model, @RequestParam(defaultValue = "0") int id){
        model.addAttribute("cart", cart);
        model.addAttribute("id", id);
        return "cart";
    }

    @GetMapping(value = "/updateCart")
    public String updateCart(@ModelAttribute("cart") Map<Item, Integer> cart, Model model, @RequestParam int id, @RequestParam int quantity){
        Item item = itemService.findById(id);
        cart.replace(item, cart.get(item), quantity);
        return "redirect:/cart";
    }

    @GetMapping("/delete")
    public String deleteCart(@ModelAttribute("cart") Map<Item, Integer> cart, @RequestParam(defaultValue = "0") int id){
        if (id == 0){
            cart.clear();
        } else {
            Item item = itemService.findById(id);
            if (item != null){
                cart.remove(item);
            }
        }
        return "redirect:/cart";
    }

}
