package com.trendyol.presentation.sellerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericRestExceptionHandler {

    @ExceptionHandler(TooManyRequest.class)
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    public ExceptionDTO handleDomainNotFoundException(TooManyRequest exception) {
        return ExceptionDTO
                .builder()
                .key(exception.getKey())
                .build();
    }
}
