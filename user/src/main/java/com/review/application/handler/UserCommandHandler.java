package com.review.application.handler;

import com.review.application.command.AddUserCommand;
import com.review.application.command.DeleteUserCommand;
import com.review.application.dto.UserIdDto;
import com.review.application.exception.UserNotFoundException;
import com.review.application.mapper.UserMapper;
import com.review.application.usecase.AddUserUseCase;
import com.review.application.usecase.DeleteUserUseCase;
import com.review.domain.UnitOfWork;
import com.review.domain.model.User;
import com.review.domain.model.UserId;
import com.review.domain.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserCommandHandler
      implements AddUserUseCase, DeleteUserUseCase {

    private final UserMapper userMapper;

    private final UserService userService;

    private final UnitOfWork unitOfWork;

    @Override
    public UserIdDto execute(AddUserCommand command) {
        return unitOfWork.run(() -> {
            User model = userMapper.toModel(command);
            UserId userId = userService.save(model);
            return userMapper.toUserIdDto(userId);
        });
    }

    @Override
    public void execute(DeleteUserCommand command) {
        unitOfWork.run(() -> {
            UserId userId = userMapper.toUserId(command);

            boolean exists = userService.exists(userId);
            if (!exists) {
                UserIdDto userIdDto = command.userId();
                throw new UserNotFoundException(userIdDto);
            }

            userService.delete(userId);
        });
    }

}
