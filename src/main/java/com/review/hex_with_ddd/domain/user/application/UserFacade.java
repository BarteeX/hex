package com.review.hex_with_ddd.domain.user.application;

import com.review.hex_with_ddd.domain.user.application.command.AddUserCommand;
import com.review.hex_with_ddd.domain.user.application.dto.UserIdDto;
import com.review.hex_with_ddd.domain.user.application.mapper.UserMapper;
import com.review.hex_with_ddd.domain.user.application.usecase.AddUserUseCase;
import com.review.hex_with_ddd.domain.user.domain.model.User;
import com.review.hex_with_ddd.domain.user.domain.model.UserId;
import com.review.hex_with_ddd.domain.user.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserFacade
        implements AddUserUseCase {

    private final UserMapper userMapper;

    private final UserService userRepository;

    @Override
    @Transactional
    public UserIdDto execute(AddUserCommand command) {
        User model = userMapper.toModel(command);
        UserId userId = userRepository.save(model);
        return userMapper.toUserIdDto(userId);
    }

}
