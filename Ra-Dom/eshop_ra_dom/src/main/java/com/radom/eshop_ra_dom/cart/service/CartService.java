package com.radom.eshop_ra_dom.cart.service;

import com.radom.eshop_ra_dom.cart.dto.CartDto;
import com.radom.eshop_ra_dom.cart.dto.CartItem;
import com.radom.eshop_ra_dom.product.dto.ProductDto;
import com.radom.eshop_ra_dom.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductService productService;


    public void addToCartByProductId(UUID productId, CartDto cart) {
        this.getCartItem(productId, cart.getCartItems()).ifPresentOrElse(
                CartItem::incrementQuantity
                , () -> addProductToCart(productId, cart)
        );
    }

    private void addProductToCart(UUID productId, CartDto cart) {
        ProductDto productDto = productService.getProductByUUID(productId);
        cart.add(productDto);
    }

    private Optional<CartItem> getCartItem(UUID productId, List<CartItem> cartItems) {
           return cartItems.stream()
                    .filter(ci -> ci.getProductDto().getProductId().equals(productId))
                    .findAny();

    }
}
