package org.example.eshop.controller;

import org.example.eshop.product.dto.ProductDto;
import org.example.eshop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductApiController {

    private final ProductService productService;

    @ResponseBody
    @GetMapping(produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}) // by default produces JSON MIME type
    public List<ProductDto> getJsonProducts() {
        return productService.getProducts();
    }

}