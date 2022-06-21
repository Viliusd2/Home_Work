package org.example.eshop.api.cart.controller;

import io.swagger.annotations.Api;
import org.example.eshop.cart.dto.CartDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.UUID;

@RequestMapping("/api")
@Api(tags = "Cart Controller")
public interface CartApiSpec {


    @GetMapping(path = "/cart", produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
     CartDto getCart(@ModelAttribute("cartSession") CartDto cart);

    @PostMapping( "/cart/{productId}")
    ResponseEntity<Void> addToCart(@PathVariable UUID productId, @ModelAttribute("cartSession") CartDto cart);

    @PostMapping("/cart")
    ResponseEntity<Void> orderSave(SessionStatus sessionStatus, RedirectAttributes redirectAttributes, @ModelAttribute("cartSession")CartDto cart, Principal principal);

}
