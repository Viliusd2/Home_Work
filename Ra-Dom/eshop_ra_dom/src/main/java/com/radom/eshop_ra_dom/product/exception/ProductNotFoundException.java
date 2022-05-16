package com.radom.eshop_ra_dom.product.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

//@ResponseStatus(HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
@Getter
public class ProductNotFoundException extends RuntimeException {
    private final UUID productId;
}
