package com.review.hex_with_ddd.core.authentication.adapter.out;

import com.review.hex_with_ddd.core.authentication.domain.port.AuthenticationPasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationPasswordEncoderAdapter
      implements AuthenticationPasswordEncoder {

    private final PasswordEncoder passwordEncoder;


    @Override
    public String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

}
