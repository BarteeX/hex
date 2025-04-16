package com.review.hex_with_ddd.core.authentication.domain.port;

public interface AuthenticationPasswordEncoder {

    String encode(String rawPassword);

    boolean matches(String rawPassword, String encodedPassword);

}
