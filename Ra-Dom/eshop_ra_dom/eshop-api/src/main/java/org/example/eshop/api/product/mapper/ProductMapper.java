package org.example.eshop.api.product.mapper;

import org.example.eshop.api.product.dto.ProductDto;
import org.example.eshop.jpa.file.entity.File;
import org.example.eshop.jpa.product.entity.Product;
import org.example.eshop.jpa.product.entity.ProductCategory;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
public class ProductMapper {

    public ProductDto mapToDto(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .flavor(product.getFlavor())
                .description(product.getDescription())
                .quantityInStock(product.getCountOfStock())
                .portionSize(product.getPortionSize())
                .fileName(product.getImage().getUniqFileName())
                .build();
    }

    public Product mapToEntity(ProductDto productDto, ProductCategory productCategory, File file){
        return Product.builder()
                .productId(UUID.randomUUID())
                .name(productDto.getName())
                .countOfStock(productDto.getQuantityInStock())
                .portionSize(productDto.getPortionSize())
                .price(productDto.getPrice())
                .flavor(productDto.getFlavor())
                .description(productDto.getDescription())
                .productCategories(Set.of(productCategory))
                .image(file)
                .build();
    }
}
