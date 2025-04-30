package com.review.domain.repository;

import com.review.domain.UserId;
import com.review.domain.model.UserAuthenticationState;

import java.util.Optional;

public interface UserAuthenticationStateRepository {

    Optional<UserAuthenticationState> findByUserId(UserId userId);

    void save(UserAuthenticationState userAuthenticationState);

}
