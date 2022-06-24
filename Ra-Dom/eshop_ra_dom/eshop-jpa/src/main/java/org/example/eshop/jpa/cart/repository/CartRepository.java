package org.example.eshop.jpa.cart.repository;

import org.example.eshop.jpa.cart.entity.Cart;
import org.example.eshop.jpa.product.entity.Product;
import org.example.eshop.jpa.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByCartId(UUID id);

    Set<Cart> findCartsByUserEmail(String username);
}
