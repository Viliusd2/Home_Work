package com.radom.eshop_ra_dom.cart.dto;

import com.radom.eshop_ra_dom.product.dto.ProductDto;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CartItem {
    private final ProductDto productDto;
    private Integer quantity;


    public void incrementQuantity (){
        quantity++;
    }

}
