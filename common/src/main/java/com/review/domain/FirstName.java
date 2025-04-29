package com.review.domain;

public class FirstName
      extends ValueObject<String> {

    private FirstName(String value) {
        super(value);
    }

    public static FirstName of(String firstName) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }
        return new FirstName(firstName);
    }

}
