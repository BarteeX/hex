package com.review.hex_with_ddd.core.user.domain.service;

import com.review.hex_with_ddd.core.user.domain.model.User;
import com.review.hex_with_ddd.core.user.domain.model.UserId;
import com.review.hex_with_ddd.core.user.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserId save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(UserId userId) {
        return userRepository.findById(userId);
    }

    public void delete(UserId userId) {
        userRepository.deleteById(userId);
    }

    public boolean exists(UserId userId) {
        return userRepository.existsById(userId);
    }

}
