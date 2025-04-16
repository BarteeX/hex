package com.review.hex_with_ddd.core.authentication.domain.port;

import com.review.hex_with_ddd.core.authentication.domain.model.AuthenticationUserId;
import com.review.hex_with_ddd.core.authentication.domain.model.AuthenticationUserToken;

public interface TokenProvider {

    AuthenticationUserToken create(AuthenticationUserId userId);

}
