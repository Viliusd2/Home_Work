package org.example.eshop.controller;

import org.example.eshop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.example.eshop.EshopEndpoints.PUBLIC_WORKSPACE;

@Controller
@RequestMapping(PUBLIC_WORKSPACE + "/product-finder")
@RequiredArgsConstructor
public class ProductFinderController {

    private final ProductService productService;

    @GetMapping
    public String getProductsByName(Model model, @RequestParam String productName) {
        return "forward:"+ PUBLIC_WORKSPACE + "/product-finder/searchResult/" + productName;
    }

    @GetMapping("/searchResult/{productName}")
    public String getProductsByNameSearchResult(Model model, @PathVariable String productName, Pageable pageable) {
        model.addAttribute("productsPage", productService.getProductByNamePageable(productName, pageable));
        return "/product/products";
    }
}