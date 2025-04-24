package com.review.domain.repository;

import com.review.domain.model.AuthenticationUser;
import com.review.domain.model.AuthenticationUserId;

import java.util.Optional;

public interface AuthenticationUserRepository {

    Optional<AuthenticationUser> findById(AuthenticationUserId id);

    AuthenticationUser save(AuthenticationUser authenticationUser);

}
