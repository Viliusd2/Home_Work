package org.example.eshop.api.cart.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshop.api.cart.dto.CartResponse;
import org.example.eshop.api.cart.dto.CartDto;
import org.example.eshop.api.cart.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.security.Principal;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CartApiController implements CartApiSpec {
    private final CartService cartService;
    public ResponseEntity<Void> addProductToCart(@Valid @RequestBody CartDto cart, @PathVariable UUID productId) {
        if (cartService.addToCartByProductId(productId, cart)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> removeProductFromCart(@Valid @RequestBody CartDto cart,@PathVariable UUID productId) {
        if (cartService.removeFromCartByProductId(productId,cart)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return  ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> createCart(@Valid @RequestBody CartDto cart, Principal principal) {
        cart.setUserEmail(principal.getName());
        cartService.saveCart(cart);
        if (cartService.findCartByUUID(cart.getCartId())) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.notFound().build();
    }

    public CartResponse getCarts() {
        return CartResponse.builder()
                .carts(cartService.findAll())
                .build();
    }


    public ResponseEntity<Void> deleteCart(UUID cartId) {
        if (cartService.deleteCart(cartId)){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.notFound().build();
    }


    public CartResponse getCartsByUsername(String username) {
        return CartResponse.builder()
                .carts(cartService.findCartByUsername(username))
                .build();

    }


}
