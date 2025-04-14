package com.review.hex_with_ddd.core.user.domain.port;

import com.review.hex_with_ddd.core.user.domain.model.User;
import com.review.hex_with_ddd.core.user.domain.model.UserId;

public interface UserRepository {

    UserId save(User user);

}
