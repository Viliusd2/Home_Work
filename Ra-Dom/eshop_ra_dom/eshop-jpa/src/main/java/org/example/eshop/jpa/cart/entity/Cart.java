package org.example.eshop.jpa.cart.entity;

import org.example.eshop.jpa.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID cartId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @OneToMany
    private List<CartItem> cartItems = new ArrayList<>();



}
