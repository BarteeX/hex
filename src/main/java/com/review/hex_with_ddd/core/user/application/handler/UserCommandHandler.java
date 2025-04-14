package com.review.hex_with_ddd.core.user.application.handler;

import com.review.hex_with_ddd.common.domain.UnitOfWork;
import com.review.hex_with_ddd.core.user.application.command.AddUserCommand;
import com.review.hex_with_ddd.core.user.application.dto.UserIdDto;
import com.review.hex_with_ddd.core.user.application.mapper.UserMapper;
import com.review.hex_with_ddd.core.user.application.usecase.AddUserUseCase;
import com.review.hex_with_ddd.core.user.domain.model.User;
import com.review.hex_with_ddd.core.user.domain.model.UserId;
import com.review.hex_with_ddd.core.user.domain.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserCommandHandler
      implements AddUserUseCase {

    private final UserMapper userMapper;

    private final UserService userRepository;

    private final UnitOfWork unitOfWork;

    @Override
    public UserIdDto execute(AddUserCommand command) {
        return unitOfWork.run(() -> {
            User model = userMapper.toModel(command);
            UserId userId = userRepository.save(model);
            return userMapper.toUserIdDto(userId);
        });
    }

}
