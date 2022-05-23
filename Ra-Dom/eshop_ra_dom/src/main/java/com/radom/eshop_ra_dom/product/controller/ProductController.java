package com.radom.eshop_ra_dom.product.controller;

import com.radom.eshop_ra_dom.product.dto.ProductDto;
import com.radom.eshop_ra_dom.product.service.ProductService;
import com.radom.eshop_ra_dom.helper.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.UUID;

import static com.radom.eshop_ra_dom.EshopEndpoints.*;

@Controller
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;
    private final MessageService messageService;

    @GetMapping(PRODUCT_ROOT_PATH)
    public String openCrateProductForm(Model model, String message) {
        model.addAttribute("productDto", ProductDto.builder().build());
        model.addAttribute("message", messageService.getMessage(message));

        return "product/product";
    }

    @PostMapping(PRODUCT_ROOT_PATH)
    public String createProduct(Model model, @Valid ProductDto product, BindingResult errors, RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            return "product/product";
        }

        productService.addProduct(product);
        redirectAttributes.addFlashAttribute("message", "create.product.message.success");

        return "redirect:" + PRODUCT_ROOT_PATH;
    }

    @GetMapping(PRODUCT_LIST_PATH)
    public String getProducts(
            Model model, @PageableDefault(size = 7, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("productsPage", productService.getProductPaginated(pageable));

        return "product/products";
    }

    @GetMapping(PRODUCT_UPDATE_PATH)
    public String getUpdateProduct(Model model, @PathVariable("productId") UUID id) {
        model.addAttribute("productDto", productService.getProductByUUID(id));

        return "product/product";
    }

    @PostMapping(PRODUCT_UPDATE_PATH)
    public String getUpdateProduct(Model model, ProductDto product) {
        productService.updateProduct(product);

        return "redirect:" + PRODUCT_LIST_PATH;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(PRODUCT_DELETE_PATH)
    public String deleteProductV2(@RequestParam("productId") UUID productId) {
        productService.deleteProduct(productId);

        return "redirect:" + PRODUCT_LIST_PATH;
    }
}
