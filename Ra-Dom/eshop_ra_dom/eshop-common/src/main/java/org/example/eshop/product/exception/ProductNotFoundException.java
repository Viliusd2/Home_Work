package org.example.eshop.product.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;


@RequiredArgsConstructor
@Getter
public class ProductNotFoundException extends RuntimeException {
    private final UUID productId;
}
