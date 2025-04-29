package com.review.application.handler;

import com.review.application.dto.UserDto;
import com.review.application.dto.UserIdDto;
import com.review.application.exception.UserNotFoundException;
import com.review.application.mapper.UserMapper;
import com.review.application.query.GetUserQuery;
import com.review.application.usecase.GetUserUseCase;
import com.review.domain.UnitOfWork;
import com.review.domain.UserId;
import com.review.domain.model.User;
import com.review.domain.service.UserService;
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
