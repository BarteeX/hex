package com.review.domain;

public class Token
      extends ValueObject<String> {

    private Token(String value) {
        super(value);
    }

    public static Token of(String token) {
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("Token name cannot be null or blank");
        }
        return new Token(token);
    }

}
