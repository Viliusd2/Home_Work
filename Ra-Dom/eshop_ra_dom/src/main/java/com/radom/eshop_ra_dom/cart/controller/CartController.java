package com.radom.eshop_ra_dom.cart.controller;

import com.radom.eshop_ra_dom.cart.dto.CartDto;
import com.radom.eshop_ra_dom.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cartSession")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // defaultine sessija
    @ModelAttribute("cartSession")
    public CartDto createCart() {
        return new CartDto();
    }

    @GetMapping
    public String openCart(@ModelAttribute("cartSession") CartDto cart) {
        return "/cart/cart";
    }

    @PostMapping("/{productId}")
    public String addToCart(@PathVariable UUID productId, @ModelAttribute("cartSession") CartDto cart) {
        cartService.addToCartByProductId(productId,cart);

        return "redirect:/products/list";
    }
    @PostMapping
    public String order(SessionStatus sessionStatus, RedirectAttributes redirectAttributes){
        //TODO: save into db or do other things to cart data

        sessionStatus.setComplete();

        redirectAttributes.addFlashAttribute("successMessage", "cart.order.message.success");

        return "redirect:/products/list";
    }


}
