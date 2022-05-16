package com.radom.eshop_ra_dom.product.repository;

import com.radom.eshop_ra_dom.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
