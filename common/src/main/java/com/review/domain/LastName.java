package com.review.domain;

public class LastName
      extends ValueObject<String> {

    private LastName(String value) {
        super(value);
    }

    public static LastName of(String lastName) {
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }
        return new LastName(lastName);
    }

}
