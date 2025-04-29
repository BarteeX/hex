package com.review.domain.exception;

public class PasswordException
      extends IllegalArgumentException {

    protected PasswordException(String message) {
        super(message);
    }

    public static PasswordException emptyPassword() {
        return new PasswordException("Password cannot be null or blank");
    }

    public static PasswordException notMatchingToRegex() {
        return new PasswordException(
              "Password must contain at least one lowercase letter, one uppercase letter, one digit, one special " +
                    "character, and be at least 8 characters long");
    }

}
