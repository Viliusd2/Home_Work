package com.radom.eshop_ra_dom.cart.mapper;

import com.radom.eshop_ra_dom.cart.dto.CartDto;
import com.radom.eshop_ra_dom.cart.entity.Cart;
import com.radom.eshop_ra_dom.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static com.radom.eshop_ra_dom.helper.DateConverter.sqlDateFormatToLocal;

@Component
@RequiredArgsConstructor
public class CartMapper {

    private final CartItemMapper cartItemMapper;

    public CartDto toCartDto(Cart cart){

        return CartDto.builder()
                .purchaseDate(sqlDateFormatToLocal(cart.getPurchaseDate()))
                .userEmail(cart.getUser().getEmail())
                .cartItemsDto(cart.getCartItems().stream()
                        .map(cartItemMapper::toCartItemDto)
                        .collect(Collectors.toUnmodifiableList()))
                .build();
    }

}
