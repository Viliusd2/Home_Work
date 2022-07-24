package org.example.eshop.jpa.product.repository;

import org.example.eshop.jpa.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
