package com.review.domain.port;

import com.review.domain.UserId;
import com.review.domain.model.User;

import java.util.Optional;

public interface UserRepository {

    UserId save(User user);

    Optional<User> findById(UserId userId);

    void deleteById(UserId userId);

    boolean existsById(UserId userId);

}
