package com.radom.eshop_ra_dom.mapper;

import com.radom.eshop_ra_dom.dto.ProductDto;
import com.radom.eshop_ra_dom.entity.Product;
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
                .build();
    }
}
