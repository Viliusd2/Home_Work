package org.example.eshop.api.cart.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshop.cart.dto.CartDto;
import org.example.eshop.cart.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CartApiController implements CartApiSpec {

    private final CartService cartService;

    @ModelAttribute("cartSession")
    public CartDto createCart() {

        return CartDto.builder()
                .cartItemsDto(new ArrayList<>())
                .cartId(UUID.randomUUID())
                .userEmail("")
                .purchaseDate(LocalDate.now())
                .build();
    }

    public CartDto getCart(@ModelAttribute("cartSession") CartDto cart) {
        return cart;
    }

    public ResponseEntity<Void> addToCart(@PathVariable UUID productId, @ModelAttribute("cartSession") CartDto cart) {
        if (cartService.addToCartByProductId(productId, cart)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> orderSave(
            SessionStatus sessionStatus,
            RedirectAttributes redirectAttributes,
            @ModelAttribute("cartSession") CartDto cart,
            Principal principal) {
        cart.setUserEmail(principal.getName());
        cartService.saveCart(cart);
        sessionStatus.setComplete();
        if (cartService.findCartByUUID(cart.getCartId())) {
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "cart.order.message.success");
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.notFound().build();
    }



}
