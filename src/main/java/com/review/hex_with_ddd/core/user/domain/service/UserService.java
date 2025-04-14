package com.review.hex_with_ddd.core.user.domain.service;

import com.review.hex_with_ddd.core.user.domain.model.User;
import com.review.hex_with_ddd.core.user.domain.model.UserId;
import com.review.hex_with_ddd.core.user.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserId save(User user) {
        return userRepository.save(user);
    }

    public User findById(UserId userIdDto) {
        return null;
    }

}
