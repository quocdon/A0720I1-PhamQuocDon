package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ModelAndView viewList() {
        return new ModelAndView("index", "products", productService.findAll());
    }

    @GetMapping("/product/{id}/view")
    public ModelAndView viewProduct(@PathVariable int id){
        return new ModelAndView("view", "product", productService.findById(id));
    }

    @GetMapping("/product/{id}/delete")
    public String deleteProduct(@PathVariable int id, RedirectAttributes redirectAttributes){
        productService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete product successfully");
        return "redirect:/";
    }

    @GetMapping("/product/create")
    public ModelAndView createProduct(){
        return new ModelAndView("create", "product", new Product());
    }

    @PostMapping("/product/save")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes){
        product.setId(productService.generateNewId());
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Add product successfully");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    public ModelAndView editProduct(@PathVariable int id){
        return new ModelAndView("edit", "product", productService.findById(id));
    }

    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirectAttributes){
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Update product successfully");
        return "redirect:/";
    }
}
