package com.radom.eshop_ra_dom.product.service;

import com.radom.eshop_ra_dom.cart.dto.CartItemDto;
import com.radom.eshop_ra_dom.cart.entity.CartItem;
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
    public void updateProduct(ProductDto productDto) {
        Product product = getProductByUUID(productDto);
            productRepository.save(product);

    }

    @Transactional
    public void deleteProduct(UUID uuid) {
        Optional<Product> product = productRepository.findByProductId(uuid);
        product.ifPresent(value -> productRepository.deleteById(value.getId()));
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
