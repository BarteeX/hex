package com.review.domain.service;

import com.review.domain.Password;
import com.review.domain.UserId;
import com.review.domain.model.AuthenticationUser;
import com.review.domain.port.AuthenticationPasswordEncoder;
import com.review.domain.repository.AuthenticationUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class AuthenticationUserService {

    private final AuthenticationUserRepository userRepository;

    private final AuthenticationPasswordEncoder passwordEncoder;

    public AuthenticationUser createUser(AuthenticationUser user) {
        Password password = user.getPassword();

        user.setEncodedPassword(password, passwordEncoder::encode);

        return userRepository.save(user);
    }

    public boolean isPasswordValid(AuthenticationUser user) {
        UserId id = user.getId();
        Optional<AuthenticationUser> byId = userRepository.findById(id);

        Password candidatePassword = user.getPassword();

        return byId.map((existing) -> existing.isPasswordValid(candidatePassword, passwordEncoder::matches))
              .orElse(false);
    }

}
