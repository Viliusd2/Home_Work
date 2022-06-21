package org.example.eshop.cart.mapper;


import org.example.eshop.cart.dto.CartItemDto;
import org.example.eshop.jpa.cart.entity.CartItem;
import org.example.eshop.product.mapper.ProductMapper;
import org.example.eshop.product.service.ProductService;
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
