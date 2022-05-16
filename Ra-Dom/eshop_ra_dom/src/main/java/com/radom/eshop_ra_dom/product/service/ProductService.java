package com.radom.eshop_ra_dom.product.service;

import com.radom.eshop_ra_dom.product.dto.ProductDto;
import com.radom.eshop_ra_dom.product.entity.Product;
import com.radom.eshop_ra_dom.product.entity.ProductCategory;
import com.radom.eshop_ra_dom.product.exception.ProductNotFoundException;
import com.radom.eshop_ra_dom.product.mapper.ProductMapper;
import com.radom.eshop_ra_dom.product.repository.ProductCategoryRepository;
import com.radom.eshop_ra_dom.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductMapper mapper;

    @Transactional
    public void addProduct(ProductDto productDto) {
        ProductCategory productCategory = ProductCategory.builder()
                .name("NaN")
                .build();

        productRepository.save(Product.builder()
                .productId(UUID.randomUUID())
                .name(productDto.getName())
                .countOfStock(productDto.getQuantity())
                .price(productDto.getPrice())
                .flavor(productDto.getFlavor())
                .productCategories(Set.of(productCategory))
                .build());
    }

    public Page<ProductDto> getProductPaginated(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(mapper::mapTo);
    }

    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream()
                .map(mapper::mapTo)
                .collect(Collectors.toList());
    }

    public ProductDto getProductByUUID(UUID id) {
        return productRepository.findByProductId(id)
                .map(mapper::mapTo)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Transactional
    public void updateProduct(ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findByProductId(productDto.getProductId());

        if (productOptional.isPresent()) {
            Product product = productOptional.get().toBuilder()
                    .name(productDto.getName())
                    .countOfStock(productDto.getQuantity())
                    .price(productDto.getPrice())
                    .flavor(productDto.getFlavor())
                    .build();

            productRepository.save(product);
        }
    }

    @Transactional
    public void deleteProduct(UUID uuid) {
        Optional<Product> product = productRepository.findByProductId(uuid);
        product.ifPresent(value -> productRepository.deleteById(value.getId()));
    }

    public Page<ProductDto> getProductByNamePageable(String productName, Pageable pageable) {
        return productRepository.findProductsByNameIsLikeIgnoreCase(
                        convertToLikeResult(productName), pageable)
                .map(mapper::mapTo);
    }

    private String convertToLikeResult(String value) {
        return '%' + value + '%';
    }
}
