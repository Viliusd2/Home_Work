package org.example.eshop.api.advice;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ApiExceptionResponse {

    private final String message;
    private final int status;

    @Builder.Default
    private final String timestamp = LocalDateTime.now().toString();
}
