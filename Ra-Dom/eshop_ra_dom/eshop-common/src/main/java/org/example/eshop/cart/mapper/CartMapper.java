package org.example.eshop.cart.mapper;


import lombok.RequiredArgsConstructor;
import org.example.eshop.DateConverter;
import org.example.eshop.cart.dto.CartDto;
import org.example.eshop.jpa.cart.entity.Cart;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartMapper {

    private final CartItemMapper cartItemMapper;

    public CartDto toCartDto(Cart cart){

        return CartDto.builder()
                .purchaseDate(DateConverter.sqlDateFormatToLocal(cart.getPurchaseDate()))
                .cartId(cart.getCartId())
                .userEmail(cart.getUser().getEmail())
                .cartItemsDto(cart.getCartItems().stream()
                        .map(cartItemMapper::mapToCartItemDto)
                        .collect(Collectors.toUnmodifiableList()))
                .build();
    }

}
