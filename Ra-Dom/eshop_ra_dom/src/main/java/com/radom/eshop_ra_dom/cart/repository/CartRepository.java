package com.radom.eshop_ra_dom.cart.repository;

import com.radom.eshop_ra_dom.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
