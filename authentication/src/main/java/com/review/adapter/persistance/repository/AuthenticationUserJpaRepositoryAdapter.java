package com.review.adapter.persistance.repository;

import com.review.adapter.persistance.mapper.AuthenticationUserEntityMapper;
import com.review.domain.model.AuthenticationUser;
import com.review.domain.model.AuthenticationUserId;
import com.review.domain.repository.AuthenticationUserRepository;
import com.review.infrastructure.db.AuthenticationUserEntity;
import com.review.infrastructure.db.AuthenticationUserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuthenticationUserJpaRepositoryAdapter
      implements AuthenticationUserRepository {

    private final AuthenticationUserJpaRepository authenticationUserJpaRepository;

    private final AuthenticationUserEntityMapper authenticationUserEntityMapper;

    @Override
    public Optional<AuthenticationUser> findById(AuthenticationUserId id) {
        UUID entityId = id.getId();
        Optional<AuthenticationUserEntity> entity = authenticationUserJpaRepository.findById(entityId);
        return entity.map(authenticationUserEntityMapper::toModel);
    }

    @Override
    public AuthenticationUser save(AuthenticationUser authenticationUser) {
        AuthenticationUserEntity entity = authenticationUserEntityMapper.toEntity(authenticationUser);
        AuthenticationUserEntity savedEntity = authenticationUserJpaRepository.save(entity);
        return authenticationUserEntityMapper.toModel(savedEntity);
    }

}
