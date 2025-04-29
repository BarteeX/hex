package com.review.domain;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor(staticName = "of")
public class Username
      extends ValueObject<String> {

    private static final int MIN_LENGTH = 4;

    public Username(String value) {
        super(value);
    }
    
    public static Username of(String username) {
        Optional.ofNullable(username)
              .map(String::trim)
              .filter(s -> !s.isEmpty())
              .filter(s -> s.length() >= MIN_LENGTH)
              .orElseThrow(() -> new IllegalArgumentException(
                                 "Username must have at least %d characters".formatted(MIN_LENGTH)
                           )
              );

        return new Username(username);
    }

}
