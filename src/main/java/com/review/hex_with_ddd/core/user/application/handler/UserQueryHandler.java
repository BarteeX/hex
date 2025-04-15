package com.review.hex_with_ddd.core.user.application.handler;

import com.review.hex_with_ddd.common.domain.UnitOfWork;
import com.review.hex_with_ddd.core.user.application.command.GetUserQuery;
import com.review.hex_with_ddd.core.user.application.dto.UserDto;
import com.review.hex_with_ddd.core.user.application.dto.UserIdDto;
import com.review.hex_with_ddd.core.user.application.exception.UserNotFoundException;
import com.review.hex_with_ddd.core.user.application.mapper.UserMapper;
import com.review.hex_with_ddd.core.user.application.usecase.GetUserUseCase;
import com.review.hex_with_ddd.core.user.domain.model.User;
import com.review.hex_with_ddd.core.user.domain.model.UserId;
import com.review.hex_with_ddd.core.user.domain.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserQueryHandler
      implements GetUserUseCase {

    private final UserMapper userMapper;

    private final UserService userService;

    private final UnitOfWork unitOfWork;

    @Override
    public UserDto execute(GetUserQuery query) {
        return unitOfWork.readOnly(() -> {
            UserIdDto userIdDto = query.userId();
            UserId userId = userMapper.toUserId(userIdDto);
            User byId = userService.findById(userId)
                  .orElseThrow(() -> new UserNotFoundException(userIdDto));
            return userMapper.toUserDto(byId);
        });
    }

}
