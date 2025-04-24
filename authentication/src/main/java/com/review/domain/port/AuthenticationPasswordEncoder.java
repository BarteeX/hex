package com.review.domain.port;

public interface AuthenticationPasswordEncoder {

    String encode(String rawPassword);

    boolean matches(String rawPassword, String encodedPassword);

}
