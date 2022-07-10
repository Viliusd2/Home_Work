package org.example.eshop.api.cart.service;


import lombok.RequiredArgsConstructor;
import org.example.eshop.api.cart.dto.CartDto;
import org.example.eshop.api.cart.dto.CartItemDto;
import org.example.eshop.api.cart.mapper.CartItemMapper;
import org.example.eshop.api.cart.mapper.CartMapper;
import org.example.eshop.api.product.DateConverter;
import org.example.eshop.api.product.dto.ProductDto;
import org.example.eshop.api.product.service.ProductService;
import org.example.eshop.jpa.cart.entity.Cart;
import org.example.eshop.jpa.cart.entity.CartItem;
import org.example.eshop.jpa.cart.repository.CartItemRepository;
import org.example.eshop.jpa.cart.repository.CartRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductService productService;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;
    private final CartMapper cartMapper;

    public boolean addToCartByProductId(UUID productId, CartDto cart) {
        this.getCartItem(productId, cart.getCartItemsDto())
                .ifPresentOrElse(CartItemDto::incrementQuantity
                        , () -> addProductToCart(productId, cart)
                );
        return true;
    }
    public boolean removeFromCartByProductId(UUID productId, CartDto cart) {
        if (this.getCartItem(productId, cart.getCartItemsDto()).isPresent()
                && this.getCartItem(productId, cart.getCartItemsDto()).get().getQuantity() > 0){
            this.getCartItem(productId, cart.getCartItemsDto()).get().decrementQuantity();
        }else {
            cart.remove(productService.getProductDtoByUUID(productId));
        }
        return true;
    }


    private void addProductToCart(UUID productId, CartDto cart) {
        ProductDto productDto = productService.getProductDtoByUUID(productId);
        cart.add(productDto);
    }

    private Optional<CartItemDto> getCartItem(UUID productId, List<CartItemDto> cartItems) {
        return cartItems.stream()
                .filter(ci -> ci.getProductDto().getProductId().equals(productId))
                .findAny();

    }

    @Transactional
    public void saveCart(CartDto cartDto) {
        List<CartItem> cartItemList = getCartItems(cartDto.getCartItemsDto());
        cartItemRepository.saveAll(cartItemList);

        cartRepository.save(Cart.builder()
                .purchaseDate(DateConverter.localDateFormatToSql(cartDto.getPurchaseDate()))
                .cartId(cartDto.getCartId())
                .cartItems(cartItemList)
                .build());
        productService.updateProductsAfterPurchase(cartDto.getCartItemsDto());
    }

    private List<CartItem> getCartItems(List<CartItemDto> cartItemDto) {
        return cartItemDto.stream()
                .map(cartItemMapper::mapToCartItemEntity)
                .collect(Collectors.toList());

    }

    public boolean findCartByUUID(UUID cartId) {
        return cartRepository.findByCartId(cartId).isPresent();
    }

    public List<CartDto> findAll() {
        return cartRepository.findAll().stream()
                .map(cartMapper::toCartDto)
                .collect(Collectors.toList());
    }


    public boolean deleteCart(UUID cartId) {
        Optional<Cart> cart = cartRepository.findByCartId(cartId);
        cart.ifPresent(value -> cartRepository.deleteById(value.getId()));
        return cartRepository.findByCartId(cartId).isEmpty();
    }
}
