package com.radom.eshop_ra_dom.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cartSession")
public class CartController {
// defaultine sessija
    @ModelAttribute("cartSession")
    public String createCart() {
        return "Labas";
    }

    @GetMapping
    public String openCart(@ModelAttribute("cartSession") String cart){
        return "/cart/cart";
    }
//    @GetMapping("/add")
//    public String addToCart(Model model){
//        model.addAttribute("cartSession", "Labas");
//
//        return "redirect:/cart";
//    }
}
