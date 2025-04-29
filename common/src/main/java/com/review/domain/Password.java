package com.review.domain;

import com.review.domain.exception.PasswordException;
import org.apache.commons.lang3.function.ToBooleanBiFunction;

import java.util.function.Function;
import java.util.regex.Pattern;

public class Password
      extends ValueObject<String> {

    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,}$";

    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    private Password(String value) {
        super(value);
    }

    public static Password of(String password) {
        if (password == null || password.isBlank()) {
            throw PasswordException.emptyPassword();
        }

        java.util.regex.Matcher matcher = PASSWORD_PATTERN.matcher(password);
        if (!matcher.matches()) {
            throw PasswordException.notMatchingToRegex();
        }

        return new Password(password);
    }

    public static Password encode(Password password, Encoder encoder) {
        String rawPassword = password.getValue();
        String encodedPassword = encoder.apply(rawPassword);
        return new Password(encodedPassword);
    }

    public boolean isPasswordValid(Password password, Matcher matcher) {
        String candidate = password.getValue();
        String encoded = this.getValue();
        return matcher.applyAsBoolean(candidate, encoded);
    }

    public interface Encoder
          extends Function<String, String> {

    }

    public interface Matcher
          extends ToBooleanBiFunction<String, String> {

    }

}
