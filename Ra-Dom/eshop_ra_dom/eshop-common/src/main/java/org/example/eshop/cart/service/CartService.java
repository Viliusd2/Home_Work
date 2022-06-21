package org.example.eshop.cart.service;

import org.example.eshop.DateConverter;
import org.example.eshop.cart.dto.CartDto;
import org.example.eshop.cart.dto.CartItemDto;
import org.example.eshop.jpa.cart.entity.Cart;
import org.example.eshop.jpa.cart.entity.CartItem;
import org.example.eshop.cart.mapper.CartItemMapper;
import org.example.eshop.cart.mapper.CartMapper;
import org.example.eshop.jpa.cart.repository.CartItemRepository;
import org.example.eshop.jpa.cart.repository.CartRepository;
import org.example.eshop.product.dto.ProductDto;
import org.example.eshop.product.service.ProductService;
import org.example.eshop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductService productService;
    private final UserService userService;
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
                .user(userService.checkAndReturnUserIfExists(cartDto.getUserEmail()))
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
}
