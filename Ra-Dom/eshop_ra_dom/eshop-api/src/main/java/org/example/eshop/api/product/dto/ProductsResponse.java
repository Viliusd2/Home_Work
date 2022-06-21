package org.example.eshop.api.product.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import org.example.eshop.product.dto.ProductDto;

import java.util.List;

@Builder
@Getter
public class ProductsResponse {
    @ApiModelProperty(notes = "Products list", required = true, allowEmptyValue = false)
    private List<ProductDto> products;
}
