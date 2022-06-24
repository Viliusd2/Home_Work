package org.example.eshop.api.cart.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.eshop.api.cart.dto.CartResponse;
import org.example.eshop.cart.dto.CartDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.security.Principal;
import java.util.UUID;

@RequestMapping("/api")
@Api(tags = "Cart Controller")
public interface CartApiSpec {

    //Turi būti įgyvendintos visos CRUD operacijos (CREATE, READ, UPDATE, DELETE).​
    @PutMapping( "/cart/add/{productId}")
    @ApiOperation(value = "Add product to cart",
            httpMethod = "PUT",
            notes = "Add selected product to your cart")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai idedame producta i pirkiniu krepseli"),
    })
    ResponseEntity<Void> addProductToCart(@Valid @RequestBody CartDto cart ,@PathVariable("productId") UUID productId);

    @PutMapping( "/cart/remove/{productId}")
    @ApiOperation(value = "Remove product from cart",
            httpMethod = "PUT",
            notes = "Remove selected product from your cart")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai pasaliname producta is pirkiniu krepselio"),
    })
    ResponseEntity<Void> removeProductFromCart(@Valid @RequestBody CartDto cart,@PathVariable("productId") UUID productId);

    @PostMapping("/cart")
    @ApiOperation(value = "Create Cart",
            httpMethod = "POST",
            notes = "Save cart with all the selected products as a Purchase order")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai sukuriamas uzsakymas"),
    })
    ResponseEntity<Void> createCart(@Valid @RequestBody CartDto cart, Principal principal);

    @GetMapping(path = "/carts", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get All carts",
            httpMethod = "GET",
            notes = "Retrieve all Carts from repository")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai operacija sekmingai ivykdyta"),
    })
    CartResponse getCarts();

    @DeleteMapping("/carts/{uuid}")
    @ApiOperation(value = "Delete Cart",
            httpMethod = "DELETE",
            notes = "Deletes Cart From Database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai operacija sekmingai ivykdyta"),
    })
    ResponseEntity<Void> deleteCart(@PathVariable("uuid") UUID CartId);

    @GetMapping(value = "/carts/{username}",produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Get user carts",
            httpMethod = "GET",
            notes = "Retrieve all purchases made by that user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai operacija sekmingai ivykdyta"),
    })
    CartResponse getCartsByUsername(@PathVariable("username") String username);
}
