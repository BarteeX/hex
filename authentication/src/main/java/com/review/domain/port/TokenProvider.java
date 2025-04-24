package com.review.domain.port;

import com.review.domain.model.AuthenticationUserId;
import com.review.domain.model.AuthenticationUserToken;

public interface TokenProvider {

    AuthenticationUserToken create(AuthenticationUserId userId);

}
