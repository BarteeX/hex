package com.review.domain;

public class ErrorMessage
      extends ValueObject<String> {

    private ErrorMessage(String value) {
        super(value);
    }

    public static ErrorMessage of(String firstName) {
        return new ErrorMessage(firstName);
    }

    public static ErrorMessage empty() {
        return new ErrorMessage("");
    }

}
