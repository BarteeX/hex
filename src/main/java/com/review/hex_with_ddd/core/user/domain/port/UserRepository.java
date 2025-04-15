package com.review.hex_with_ddd.core.user.domain.port;

import com.review.hex_with_ddd.core.user.domain.model.User;
import com.review.hex_with_ddd.core.user.domain.model.UserId;

import java.util.Optional;

public interface UserRepository {

    UserId save(User user);

    Optional<User> findById(UserId userId);

    void deleteById(UserId userId);

    boolean existsById(UserId userId);

}
