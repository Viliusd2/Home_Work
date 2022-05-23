package com.radom.eshop_ra_dom.product.mapper;

import com.radom.eshop_ra_dom.product.dto.ProductDto;
import com.radom.eshop_ra_dom.product.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto mapTo(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .quantity(product.getCountOfStock())
                .price(product.getPrice())
                .flavor(product.getFlavor())
                .description(product.getDescription())
                .build();
    }
}
