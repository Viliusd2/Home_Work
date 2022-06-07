package com.radom.eshop_ra_dom.product.mapper;

import com.radom.eshop_ra_dom.product.dto.ProductDto;
import com.radom.eshop_ra_dom.product.entity.Product;
import com.radom.eshop_ra_dom.product.entity.ProductCategory;
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
                .build();
    }

    public Product mapToEntity(ProductDto productDto, ProductCategory productCategory){
        return Product.builder()
                .productId(UUID.randomUUID())
                .name(productDto.getName())
                .countOfStock(productDto.getQuantityInStock())
                .portionSize(productDto.getPortionSize())
                .price(productDto.getPrice())
                .flavor(productDto.getFlavor())
                .description(productDto.getDescription())
                .productCategories(Set.of(productCategory))
                .build();
    }
}
