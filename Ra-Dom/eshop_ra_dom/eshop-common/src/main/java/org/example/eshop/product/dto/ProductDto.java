package org.example.eshop.product.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class ProductDto {

    private UUID productId;

    @NotBlank(message = "{validate.name.blank}")
    @Size(
            min = 3,
            max = 40,
            message = "{validate.name.size}"
    )
    private String name;

    @PositiveOrZero
    @Max(value = 1000)
    @NotNull
    private Integer quantityInStock;

    @PositiveOrZero
    @Max(value = 1000)
    @NotNull
    private Integer portionSize;

    @Positive
    @NotNull
    private BigDecimal price;

    @NotBlank
    private String flavor;

    @NotBlank
    private String description;
}
