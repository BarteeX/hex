package com.review.hex_with_ddd.core.user.application.mapper;

import com.review.hex_with_ddd.core.user.application.command.AddUserCommand;
import com.review.hex_with_ddd.core.user.application.dto.UserDto;
import com.review.hex_with_ddd.core.user.application.dto.UserIdDto;
import com.review.hex_with_ddd.core.user.domain.model.User;
import com.review.hex_with_ddd.core.user.domain.model.UserId;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User toModel(AddUserCommand command);

    UserIdDto toUserIdDto(UserId userId);

    UserId toUserId(UserIdDto userIdDto);

    UserDto toUserDto(User user);

}
