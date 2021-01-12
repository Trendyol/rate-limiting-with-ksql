package com.trendyol.presentation.sellerservice.exception;

public class TooManyRequest extends RuntimeException {

    private final String key;

    public TooManyRequest(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
