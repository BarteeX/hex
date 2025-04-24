package com.review.domain.port;

import com.review.domain.model.User;
import com.review.domain.model.UserId;

import java.util.Optional;

public interface UserRepository {

    UserId save(User user);

    Optional<User> findById(UserId userId);

    void deleteById(UserId userId);

    boolean existsById(UserId userId);

}
