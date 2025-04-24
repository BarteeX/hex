package com.review.domain.service;

import com.review.domain.model.AuthenticationUser;
import com.review.domain.model.AuthenticationUserId;
import com.review.domain.port.AuthenticationPasswordEncoder;
import com.review.domain.repository.AuthenticationUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class AuthenticationUserService {

    private final AuthenticationUserRepository userRepository;

    private final AuthenticationPasswordEncoder passwordEncoder;

    public AuthenticationUser createUser(AuthenticationUser user) {
        String encoded = getEncodedPassword(user);
        user.setPassword(encoded);

        return userRepository.save(user);
    }

    public boolean isPasswordValid(AuthenticationUser user) {
        AuthenticationUserId id = user.getId();
        Optional<AuthenticationUser> byId = userRepository.findById(id);

        return byId.map((existing) -> isPasswordMatch(existing, user))
              .orElse(false);
    }

    private String getEncodedPassword(AuthenticationUser user) {
        String password = user.getPassword();
        return passwordEncoder.encode(password);
    }

    private boolean isPasswordMatch(AuthenticationUser existing, AuthenticationUser candidate) {
        String encodedPassword = existing.getPassword();
        String rawPassword = candidate.getPassword();

        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

}
