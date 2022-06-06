package com.radom.eshop_ra_dom.cart.service;

import com.radom.eshop_ra_dom.cart.dto.CartDto;
import com.radom.eshop_ra_dom.cart.dto.CartItemDto;
import com.radom.eshop_ra_dom.cart.entity.Cart;
import com.radom.eshop_ra_dom.cart.entity.CartItem;
import com.radom.eshop_ra_dom.cart.repository.CartItemRepository;
import com.radom.eshop_ra_dom.cart.repository.CartRepository;
import com.radom.eshop_ra_dom.product.dto.ProductDto;
import com.radom.eshop_ra_dom.product.service.ProductService;
import com.radom.eshop_ra_dom.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.radom.eshop_ra_dom.helper.DateConverter.localDateFormatToSql;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductService productService;
    private final UserService userService;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;


    public void addToCartByProductId(UUID productId, CartDto cart) {
        this.getCartItem(productId, cart.getCartItemsDto())
                .ifPresentOrElse(CartItemDto::incrementQuantity
                        , () -> addProductToCart(productId, cart)
                );
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
                .purchaseDate(localDateFormatToSql(cartDto.getPurchaseDate()))
                .user(userService.checkAndReturnUserIfExists(cartDto.getUserEmail()))
                .cartItems(cartItemList)
                .build());
    }

    private List<CartItem> getCartItems(List<CartItemDto> cartItemDto) {
        return cartItemDto.stream()
                .map( (itemDto -> CartItem.builder()
                        .quantity(itemDto.getQuantity())
                        .product(productService.getProductByUUID(itemDto.getProductDto()))
                        .originalPrice(itemDto.getProductDto().getPrice())
                        .build()))
                .collect(Collectors.toList());

    }


}
