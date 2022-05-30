package com.radom.eshop_ra_dom.cart.dto;

import com.radom.eshop_ra_dom.product.dto.ProductDto;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;


@Builder
@Getter
public class CartItem {


    private ProductDto productDto;
    private Integer quantity;

    public void incrementQuantity (){
        quantity++;
    }

    public BigDecimal getItemTotalPrice(){

        return productDto.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

}
