package com.review.hex_with_ddd.core.authentication.domain.repository;

import com.review.hex_with_ddd.core.authentication.domain.model.AuthenticationUser;
import com.review.hex_with_ddd.core.authentication.domain.model.AuthenticationUserId;

import java.util.Optional;

public interface AuthenticationUserRepository {

    Optional<AuthenticationUser> findById(AuthenticationUserId id);

    AuthenticationUser save(AuthenticationUser authenticationUser);

}
