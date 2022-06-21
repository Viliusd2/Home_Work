package org.example.eshop.api.cart.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "Opening cart session",
            httpMethod = "GET",
            notes = "Get an empty cart session")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazina sessija"),
    })
     CartDto getCart(@ModelAttribute("cartSession") CartDto cart);

    @PostMapping( "/cart/{productId}")
    @ApiOperation(value = "Add product to cart",
            httpMethod = "POST",
            notes = "Add selected product to your cart")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai idedame producta i pirkiniu krepseli"),
    })
    ResponseEntity<Void> addToCart(@PathVariable UUID productId, @ModelAttribute("cartSession") CartDto cart);

    @PostMapping("/cart")
    @ApiOperation(value = "Save Cart",
            httpMethod = "GET",
            notes = "Save cart with all the selected products as a Purchase order")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai sukuriamas uzsakymas"),
    })
    ResponseEntity<Void> orderSave(SessionStatus sessionStatus, RedirectAttributes redirectAttributes, @ModelAttribute("cartSession")CartDto cart, Principal principal);

}
