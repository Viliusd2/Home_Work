package com.radom.eshop_ra_dom.cart.mapper;


import com.radom.eshop_ra_dom.cart.dto.CartItemDto;
import com.radom.eshop_ra_dom.cart.entity.CartItem;
import com.radom.eshop_ra_dom.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartItemMapper {

private ProductMapper mapper;

    public CartItemDto toCartItemDto(CartItem item){

        return CartItemDto.builder()
                .originalPrice(item.getOriginalPrice())
                .quantity(item.getQuantity())
                .productDto(mapper.mapTo(item.getProduct()))
                .build();
    }
}
