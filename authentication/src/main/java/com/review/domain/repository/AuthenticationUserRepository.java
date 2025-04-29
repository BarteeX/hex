package com.review.domain.repository;

import com.review.domain.UserId;
import com.review.domain.model.AuthenticationUser;

import java.util.Optional;

public interface AuthenticationUserRepository {

    Optional<AuthenticationUser> findById(UserId id);

    AuthenticationUser save(AuthenticationUser authenticationUser);

}
