package com.radom.eshop_ra_dom.cart.repository;

import com.radom.eshop_ra_dom.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
