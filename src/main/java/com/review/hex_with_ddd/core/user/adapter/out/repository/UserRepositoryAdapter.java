package com.review.hex_with_ddd.core.user.adapter.out.repository;

import com.review.hex_with_ddd.core.user.adapter.out.mapper.UserDBMapper;
import com.review.hex_with_ddd.core.user.domain.model.User;
import com.review.hex_with_ddd.core.user.domain.model.UserId;
import com.review.hex_with_ddd.core.user.domain.port.UserRepository;
import com.review.hex_with_ddd.core.user.infrastructure.adapter.UserDbRepository;
import com.review.hex_with_ddd.core.user.infrastructure.adapter.entity.UserDB;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class UserRepositoryAdapter
      implements UserRepository {

    private final UserDBMapper userDBMapper;

    private final UserDbRepository userRepository;

    @Override
    @Transactional
    public UserId save(User user) {
        UserDB dbModel = userDBMapper.toDbModel(user);
        UserDB savedUser = userRepository.save(dbModel);
        return userDBMapper.toModelId(savedUser);
    }

    @Override
    public Optional<User> findById(UserId userId) {
        UUID uuid = userDBMapper.toUUID(userId);
        Optional<UserDB> byId = userRepository.findById(uuid);
        return byId.map(userDBMapper::toModel);
    }

    @Override
    public void deleteById(UserId userId) {
        UUID uuid = userDBMapper.toUUID(userId);
        userRepository.deleteById(uuid);
    }

    @Override
    public boolean existsById(UserId userId) {
        UUID uuid = userDBMapper.toUUID(userId);
        return userRepository.existsById(uuid);
    }

}
