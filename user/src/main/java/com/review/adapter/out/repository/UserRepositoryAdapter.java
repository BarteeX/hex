package com.review.adapter.out.repository;

import com.review.adapter.out.mapper.UserDBMapper;
import com.review.domain.UserId;
import com.review.domain.model.User;
import com.review.domain.port.UserRepository;
import com.review.infrastructure.db.UserDbRepository;
import com.review.infrastructure.db.entity.UserDB;
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
