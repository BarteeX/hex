package com.review.domain.service;

import com.review.domain.UserId;
import com.review.domain.Username;
import com.review.domain.model.User;
import com.review.domain.port.UserRepository;
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

    public Optional<User> findByUsername(Username username) {
        return userRepository.findByUsername(username);
    }

    public void delete(UserId userId) {
        userRepository.deleteById(userId);
    }

    public boolean exists(UserId userId) {
        return userRepository.existsById(userId);
    }

}
