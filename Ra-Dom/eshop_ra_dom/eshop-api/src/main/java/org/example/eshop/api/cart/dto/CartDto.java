package org.example.eshop.api.cart.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.eshop.api.product.dto.ProductDto;

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
    private LocalDate purchaseDate;


    public void add(ProductDto productDto) {
        cartItemsDto.add(CartItemDto.builder()
                .productDto(productDto)
                .quantity(1)
                .build());
    }
    public void remove(ProductDto productDto) {
        cartItemsDto.remove(CartItemDto.builder()
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
