package org.example.eshop.cart.dto;

import org.example.eshop.product.dto.ProductDto;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Builder
@Getter
@Setter
public class CartDto {

    private UUID cartId;
    private List<CartItemDto> cartItemsDto;
    private String userEmail;
    private LocalDate purchaseDate;


    public void add(ProductDto productDto) {
        cartItemsDto.add(CartItemDto.builder()
                .productDto(productDto)
                .quantity(1)
                .build());
    }

    public BigDecimal getCartTotalPrice(){
        return cartItemsDto.stream()
                .map(CartItemDto::getItemTotalPrice)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    public Integer getCartTotalQuantity(){
        return cartItemsDto.stream()
                .map(CartItemDto::getQuantity)
                .reduce(0, Integer::sum);
    }

}
