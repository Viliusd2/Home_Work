package org.example.eshop.controller;

import org.example.eshop.cart.dto.CartDto;
import org.example.eshop.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import static org.example.eshop.EshopEndpoints.CART_ROOT_PATH;
import static org.example.eshop.EshopEndpoints.PRODUCT_LIST_PATH;

@Controller
@SessionAttributes("cartSession")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // defaultine sessija
    @ModelAttribute("cartSession")
    public CartDto createCart() {

        return CartDto.builder()
                .cartItemsDto(new ArrayList<>())
                .userEmail("")
                .purchaseDate( LocalDate.now())
                .build();
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

    @PostMapping("/cart")
    public String orderSave(SessionStatus sessionStatus, RedirectAttributes redirectAttributes, @ModelAttribute("cartSession")CartDto cart, Principal principal) {
            cart.setUserEmail(principal.getName());

            cartService.saveCart(cart);

            sessionStatus.setComplete();

            redirectAttributes.addFlashAttribute("successMessage", "cart.order.message.success");

            return "redirect:" + PRODUCT_LIST_PATH;
        }

        @GetMapping("/anonymousCheck")
    public String testGet(){
        return "redirect:" + CART_ROOT_PATH;
    }

    }
