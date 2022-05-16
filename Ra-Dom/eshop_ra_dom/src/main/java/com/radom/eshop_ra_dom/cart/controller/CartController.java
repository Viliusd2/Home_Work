package com.radom.eshop_ra_dom.cart.controller;

import com.radom.eshop_ra_dom.cart.dto.CartDto;
import com.radom.eshop_ra_dom.product.dto.ProductDto;
import com.radom.eshop_ra_dom.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cartSession")
@RequiredArgsConstructor
public class CartController {

    private final ProductService productService;

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
        ProductDto productDto = productService.getProductByUUID(productId);
        cart.add(productDto);

        return "redirect:/products/list";
    }
}
