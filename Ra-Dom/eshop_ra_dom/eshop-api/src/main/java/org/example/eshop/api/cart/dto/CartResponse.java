package org.example.eshop.api.cart.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import org.example.eshop.cart.dto.CartDto;


import java.util.List;

@Builder
@Getter
public class CartResponse {

    @ApiModelProperty(notes = "Carts list", required = true, allowEmptyValue = false)
    private List<CartDto> carts;
}
