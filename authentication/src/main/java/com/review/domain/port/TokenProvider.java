package com.review.domain.port;

import com.review.domain.UserId;
import com.review.domain.model.AuthenticationUserToken;

public interface TokenProvider {

    AuthenticationUserToken create(UserId userId);

}
