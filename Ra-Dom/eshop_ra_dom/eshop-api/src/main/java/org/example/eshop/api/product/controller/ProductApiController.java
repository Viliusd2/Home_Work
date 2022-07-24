package org.example.eshop.api.product.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshop.api.product.dto.ProductDto;
import org.example.eshop.api.product.dto.ProductsResponse;
import org.example.eshop.api.product.service.ProductService;
import org.example.eshop.swager.annotation.OpenApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@OpenApi
public class ProductApiController implements ProductApiSpec {


    private final ProductService productService;


    public ResponseEntity<Void> createProduct(@Valid @RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ProductsResponse getProducts() {
        return ProductsResponse.builder()
                .products(productService.getProducts())
                .build();
    }

    public ProductsResponse getProductByUUID(@PathVariable("uuid") UUID uuid) {
        return ProductsResponse.builder()
                .products(List.of(productService.getProductDtoByUUID(uuid)))
                .build();
    }

    public Page<ProductDto> getProductsPaginated(@RequestParam("page") int page, @RequestParam("size") int size) {
        return productService.getProductPaginated(PageRequest.of(page, size));
    }

    public ResponseEntity<Void> updateProduct(@Valid @RequestBody ProductDto productDto) {
        if (productService.updateProduct(productDto)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> deleteProduct(@PathVariable("uuid") UUID productId) {
        if(productService.deleteProduct(productId)){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.notFound().build();
    }

}