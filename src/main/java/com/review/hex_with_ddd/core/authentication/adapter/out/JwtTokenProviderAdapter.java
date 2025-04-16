package com.review.hex_with_ddd.core.authentication.adapter.out;

import com.review.hex_with_ddd.core.authentication.domain.model.AuthenticationUserId;
import com.review.hex_with_ddd.core.authentication.domain.model.AuthenticationUserToken;
import com.review.hex_with_ddd.core.authentication.domain.port.TokenProvider;
import com.review.hex_with_ddd.core.authentication.infrastructure.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtTokenProviderAdapter
      implements TokenProvider {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public AuthenticationUserToken create(AuthenticationUserId userId) {
        UUID id = userId.getId();
        String token = jwtTokenProvider.generateToken(id.toString());
        return new AuthenticationUserToken(token);
    }

}
