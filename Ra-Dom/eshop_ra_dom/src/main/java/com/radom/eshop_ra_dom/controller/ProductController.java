package com.radom.eshop_ra_dom.controller;

import com.radom.eshop_ra_dom.dto.ProductDto;
import com.radom.eshop_ra_dom.exception.ProductNotFoundException;
import com.radom.eshop_ra_dom.service.ProductService;
import com.radom.eshop_ra_dom.helper.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final MessageService messageService;

    @GetMapping
    public String openCrateProductForm(Model model, String message) {
        model.addAttribute("product", ProductDto.builder().build());
        model.addAttribute("message", messageService.getMessage(message));

        return "product/product";
    }

    @PostMapping
    public String createProduct(Model model, ProductDto product) {
        productService.addProduct(product);
        model.addAttribute("product", ProductDto.builder().build());
        return "redirect:/products?message=create.product.message.success";
    }

    @GetMapping("/list")
    public String getProducts(
            Model model, @PageableDefault(size = 7, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("productsPage", productService.getProductPaginated(pageable));

        return "product/productsList";
    }

    @GetMapping("/{productId}/update")
    public String getUpdateProduct(Model model, @PathVariable("productId") UUID id) {
        model.addAttribute("product", productService.getProductByUUID(id));

        return "product/product";
    }

    @PostMapping("/{productId}/update")
    public String getUpdateProduct(Model model, ProductDto product) {
        productService.updateProduct(product);

        return "redirect:/products/list";
    }

    @GetMapping("/{productId}/delete")
    public String deleteProduct(Model model, @PathVariable("productId") UUID id) {
        productService.deleteProduct(id);

        return "redirect:/products/list";
    }

}