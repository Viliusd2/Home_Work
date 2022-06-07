package com.radom.eshop_ra_dom.cart.mapper;


import com.radom.eshop_ra_dom.cart.dto.CartItemDto;
import com.radom.eshop_ra_dom.cart.entity.CartItem;
import com.radom.eshop_ra_dom.product.mapper.ProductMapper;
import com.radom.eshop_ra_dom.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartItemMapper {

    private final ProductService productService;

    private ProductMapper mapper;

    public CartItemDto mapToCartItemDto(CartItem item){

        return CartItemDto.builder()
                .originalPrice(item.getOriginalPrice())
                .quantity(item.getQuantity())
                .productDto(mapper.mapToDto(item.getProduct()))
                .build();
    }
    public CartItem mapToCartItemEntity(CartItemDto cartItemDto){

        return CartItem.builder()
                .quantity(cartItemDto.getQuantity())
                .product(productService.getProductByUUID(cartItemDto.getProductDto()))
                .originalPrice(cartItemDto.getProductDto().getPrice())
                .build();
    }
}
