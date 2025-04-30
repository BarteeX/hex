package com.review.adapter.persistance.repository;

import com.review.adapter.persistance.mapper.UserAuthenticationStateHashMapper;
import com.review.domain.UserId;
import com.review.domain.model.UserAuthenticationState;
import com.review.domain.repository.UserAuthenticationStateRepository;
import com.review.infrastructure.db.UserAuthenticationStateHash;
import com.review.infrastructure.db.UserAuthenticationStateHashRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UserAuthenticationStateRepositoryAdapter
      implements UserAuthenticationStateRepository {

    private final UserAuthenticationStateHashRepository hashRepository;

    private final UserAuthenticationStateHashMapper hashMapper;

    @Override
    public Optional<UserAuthenticationState> findByUserId(UserId userId) {
        UUID value = userId.getValue();
        Optional<UserAuthenticationStateHash> byId = hashRepository.findById(value);
        return byId.map(hashMapper::toDomain);
    }

    @Override
    public void save(UserAuthenticationState userAuthenticationState) {
        UserAuthenticationStateHash hash = hashMapper.toHash(userAuthenticationState);
        hashRepository.save(hash);
    }

}
