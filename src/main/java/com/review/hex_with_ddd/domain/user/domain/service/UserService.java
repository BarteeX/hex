package com.review.hex_with_ddd.domain.user.domain.service;

import com.review.hex_with_ddd.domain.user.domain.model.User;
import com.review.hex_with_ddd.domain.user.domain.model.UserId;
import com.review.hex_with_ddd.domain.user.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserId save(User user) {
        return userRepository.save(user);
    }

}
