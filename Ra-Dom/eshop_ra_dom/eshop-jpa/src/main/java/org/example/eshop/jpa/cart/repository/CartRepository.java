package org.example.eshop.jpa.cart.repository;

import org.example.eshop.jpa.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
