package com.radom.eshop_ra_dom.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID productId;

    private String name;

    @Column(name = "quantity_in_stock")
    private Integer countOfStock;

    @Column(name = "one_portion_quantity")
    private Integer portionSize;

    private BigDecimal price;

    private String flavor;

    private String description;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<ProductCategory> productCategories;
}
