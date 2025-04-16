package com.review.hex_with_ddd.core.authentication.domain.service;

import com.review.hex_with_ddd.core.authentication.domain.model.AuthenticationUser;
import com.review.hex_with_ddd.core.authentication.domain.model.AuthenticationUserId;
import com.review.hex_with_ddd.core.authentication.domain.model.AuthenticationUserToken;
import com.review.hex_with_ddd.core.authentication.domain.port.TokenProvider;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthenticationTokenService {

    private final TokenProvider tokenProvider;

    public AuthenticationUserToken createToken(AuthenticationUser user) {
        AuthenticationUserId id = user.getId();
        return tokenProvider.create(id);
    }

}
