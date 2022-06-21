package org.example.eshop.product.service;

import org.example.eshop.cart.dto.CartItemDto;
import org.example.eshop.product.dto.ProductDto;
import org.example.eshop.jpa.product.entity.Product;
import org.example.eshop.jpa.product.entity.ProductCategory;
import org.example.eshop.product.exception.ProductNotFoundException;
import org.example.eshop.product.mapper.ProductMapper;
import org.example.eshop.jpa.product.repository.ProductCategoryRepository;
import org.example.eshop.jpa.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductMapper mapper;

    @Transactional
    public void saveProduct(ProductDto productDto) {
        ProductCategory productCategory = ProductCategory.builder()
                .name("NaN")
                .build();

        productRepository.save(mapper.mapToEntity(productDto,productCategory));
    }

    public Page<ProductDto> getProductPaginated(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(mapper::mapToDto);
    }

    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    public ProductDto getProductDtoByUUID(UUID id) {
        return productRepository.findByProductId(id)
                .map(mapper::mapToDto)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product getProductByUUID(ProductDto productDto){
        Optional<Product> productOptional = productRepository.findByProductId(productDto.getProductId());
        Product product = new Product();
        if (productOptional.isPresent()) {
            product = productOptional.get().toBuilder()
                    .productId(productDto.getProductId())
                    .name(productDto.getName())
                    .countOfStock(productDto.getQuantityInStock())
                    .portionSize(productDto.getPortionSize())
                    .price(productDto.getPrice())
                    .flavor(productDto.getFlavor())
                    .description(productDto.getDescription())
                    .productCategories(productOptional.get().getProductCategories())
                    .build();

        }
        return  product;
    }

    @Transactional
    public boolean updateProduct(ProductDto productDto) {
        Product product = getProductByUUID(productDto);
        if (product != null){
            productRepository.save(product);
            return true;
        }
        return false;


    }

    @Transactional
    public boolean deleteProduct(UUID uuid) {
        Optional<Product> product = productRepository.findByProductId(uuid);
        product.ifPresent(value -> productRepository.deleteById(value.getId()));

        return productRepository.findByProductId(uuid).isEmpty();

    }

    public Page<ProductDto> getProductByNamePageable(String productName, Pageable pageable) {
        return productRepository.findProductsByNameIsLikeIgnoreCase(
                        convertToLikeResult(productName), pageable)
                .map(mapper::mapToDto);
    }

    private String convertToLikeResult(String value) {
        return '%' + value + '%';
    }


    public void updateProductsAfterPurchase(List<CartItemDto> cartItemsDto) {

        for (CartItemDto cartItemDto : cartItemsDto) {
            cartItemDto.getProductDto().setQuantityInStock(cartItemDto.getProductDto().getQuantityInStock() - cartItemDto.getQuantity());
            updateProduct(cartItemDto.getProductDto());
        }


    }
}
