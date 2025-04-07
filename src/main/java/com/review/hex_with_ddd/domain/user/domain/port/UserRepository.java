package com.review.hex_with_ddd.domain.user.domain.port;

import com.review.hex_with_ddd.domain.user.domain.model.User;
import com.review.hex_with_ddd.domain.user.domain.model.UserId;

public interface UserRepository {

    UserId save(User user);

}
