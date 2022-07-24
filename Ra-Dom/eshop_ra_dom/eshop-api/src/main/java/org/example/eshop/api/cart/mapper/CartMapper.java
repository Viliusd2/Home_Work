package org.example.eshop.api.cart.mapper;


import lombok.RequiredArgsConstructor;
import org.example.eshop.api.cart.dto.CartDto;
import org.example.eshop.api.product.DateConverter;
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
                .cartItemsDto(cart.getCartItems().stream()
                        .map(cartItemMapper::mapToCartItemDto)
                        .collect(Collectors.toUnmodifiableList()))
                .build();
    }

}
