package org.example.eshop.api.cart.mapper;


import org.example.eshop.api.cart.dto.CartItemDto;
import org.example.eshop.api.product.mapper.ProductMapper;
import org.example.eshop.api.product.service.ProductService;
import org.example.eshop.jpa.cart.entity.CartItem;
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
