package com.review.domain.service;

import com.review.domain.model.AuthenticationUser;
import com.review.domain.model.AuthenticationUserId;
import com.review.domain.model.AuthenticationUserToken;
import com.review.domain.port.TokenProvider;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthenticationTokenService {

    private final TokenProvider tokenProvider;

    public AuthenticationUserToken createToken(AuthenticationUser user) {
        AuthenticationUserId id = user.getId();
        return tokenProvider.create(id);
    }

}
