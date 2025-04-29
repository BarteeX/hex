package com.review.adapter.out;

import com.review.domain.Token;
import com.review.domain.UserId;
import com.review.domain.model.AuthenticationUserToken;
import com.review.domain.port.TokenProvider;
import com.review.infrastructure.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtTokenProviderAdapter
      implements TokenProvider {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public AuthenticationUserToken create(UserId userId) {
        UUID id = userId.getValue();
        String jwtToken = jwtTokenProvider.generateToken(id.toString());
        Token token = Token.of(jwtToken);

        return new AuthenticationUserToken(token);
    }

}
