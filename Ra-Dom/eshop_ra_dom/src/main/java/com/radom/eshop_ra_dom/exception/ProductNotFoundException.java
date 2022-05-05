package com.radom.eshop_ra_dom.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

//@ResponseStatus(HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
@Getter
public class ProductNotFoundException extends RuntimeException {
    private final UUID productId;
}
