package org.example.eshop.api.cart.dto;

import org.example.eshop.api.product.dto.ProductDto;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;



@Builder
@Getter
public class CartItemDto {

    private ProductDto productDto;
    private Integer quantity;
    private BigDecimal originalPrice;

    public void incrementQuantity (){
        this.quantity++;
    }
    public void decrementQuantity (){
        this.quantity--;
    }


    public BigDecimal getItemTotalPrice(){

        return productDto.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

}
