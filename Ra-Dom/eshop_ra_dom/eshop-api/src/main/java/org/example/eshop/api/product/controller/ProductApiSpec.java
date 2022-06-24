package org.example.eshop.api.product.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.eshop.api.product.dto.ProductsResponse;
import org.example.eshop.product.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api")
@Api(tags = "Product Controller")
public interface ProductApiSpec {

     String PRODUCT_PATH = "/product";
     String PRODUCTS_PATH = "/products";

    @PostMapping(path = "/create")
    @ApiOperation(value = "Create product",
            httpMethod = "POST",
            notes = "Create User made custom product")
    ResponseEntity<Void> createProduct(@Valid @RequestBody ProductDto productDto);

    @GetMapping(path = PRODUCTS_PATH, produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}) // by default produces JSON MIME type
    @ApiOperation(
            value = "Get all product",
            httpMethod = "GET",
            notes = "Get all product from db, and any other information could be here")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazina produktus"),
            @ApiResponse(code = 401, message = "Reikalauja prisijungimo gaunant produktu sarasa"),
            @ApiResponse(code = 403, message = "Neturite reikalingu teisiu gauti produktu sarasa")
    })
    ProductsResponse getProducts();

    @GetMapping(path = PRODUCT_PATH + "/{uuid}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Get one product by id",
            httpMethod = "GET",
            notes = "Get a product from database by UUID number")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazina produkta"),
            @ApiResponse(code = 401, message = "Reikalauja prisijungimo gaunant produkta"),
            @ApiResponse(code = 403, message = "Neturite reikalingu teisiu gauti produkta")
    })
    ProductsResponse getProductByUUID(@PathVariable("uuid") UUID uuid);


    @GetMapping(PRODUCTS_PATH + "/page")
    @ApiOperation(value = "Get a page of products",
            httpMethod = "GET",
            notes = "Get a page of products by page number and size")
    Page<ProductDto> getProductsPaginated(@RequestParam("page") int page, @RequestParam("size") int size);

    @PutMapping(path = PRODUCT_PATH + "/update")
    @ApiOperation(value = "Update product",
            httpMethod = "PUT",
            notes = "Updates a product with user modifications made to it")
    ResponseEntity<Void> updateProduct(@Valid @RequestBody ProductDto productDto);

    @DeleteMapping(path = PRODUCT_PATH + "/{uuid}")
    @ApiOperation(value = "Delete product",
            httpMethod = "DELETE",
            notes = "Deletes a product by UUID selected")
    ResponseEntity<Void> deleteProduct(@PathVariable("uuid") UUID productId);


}
