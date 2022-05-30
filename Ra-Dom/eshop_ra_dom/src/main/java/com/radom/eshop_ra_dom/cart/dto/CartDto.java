package com.radom.eshop_ra_dom.cart.dto;
import com.radom.eshop_ra_dom.product.dto.ProductDto;
import lombok.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class CartDto {

    private List<CartItem> cartItems = new ArrayList<>();


    public void add(ProductDto productDto) {
        cartItems.add(CartItem.builder()
                .productDto(productDto)
                .quantity(1)
                .build());
    }

    public BigDecimal getCartTotalPrice(){
        return cartItems.stream()
                .map(CartItem::getItemTotalPrice)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    public Integer getCartTotalQuantity(){
        return cartItems.stream()
                .map(CartItem::getQuantity)
                .reduce(0, Integer::sum);
    }

}
