package com.radom.eshop_ra_dom.cart.controller;

import com.radom.eshop_ra_dom.cart.dto.CartDto;
import com.radom.eshop_ra_dom.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.UUID;

import static com.radom.eshop_ra_dom.EshopEndpoints.CART_ROOT_PATH;
import static com.radom.eshop_ra_dom.EshopEndpoints.PRODUCT_LIST_PATH;

@Controller
@SessionAttributes("cartSession")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // defaultine sessija
    @ModelAttribute("cartSession")
    public CartDto createCart() {
        return new CartDto();
    }

    @GetMapping(CART_ROOT_PATH)
    public String openCart(@ModelAttribute("cartSession") CartDto cart) {
        return "/cart/cart";
    }

    @PostMapping(CART_ROOT_PATH + "/{productId}")
    public String addToCart(@PathVariable UUID productId, @ModelAttribute("cartSession") CartDto cart) {
        cartService.addToCartByProductId(productId, cart);

        return "redirect:" + PRODUCT_LIST_PATH;
    }

    @PostMapping("/public/cart")
    public String order(SessionStatus sessionStatus, RedirectAttributes redirectAttributes, Principal principal) {
        //TODO: save into db or do other things to cart data
        String text = "";
        try {
            text = principal.getName();

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if (text.equals("")) {
            return "login/login";
        } else {
            sessionStatus.setComplete();

            redirectAttributes.addFlashAttribute("successMessage", "cart.order.message.success");

            return "redirect:" + PRODUCT_LIST_PATH;
        }


    }
}
