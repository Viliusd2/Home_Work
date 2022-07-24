package org.example.eshop.jpa.cart.repository;

import org.example.eshop.jpa.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
