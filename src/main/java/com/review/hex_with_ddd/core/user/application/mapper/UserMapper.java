package com.review.hex_with_ddd.core.user.application.mapper;

import com.review.hex_with_ddd.core.user.application.command.AddUserCommand;
import com.review.hex_with_ddd.core.user.application.command.DeleteUserCommand;
import com.review.hex_with_ddd.core.user.application.dto.UserDto;
import com.review.hex_with_ddd.core.user.application.dto.UserIdDto;
import com.review.hex_with_ddd.core.user.domain.model.User;
import com.review.hex_with_ddd.core.user.domain.model.UserId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(
          target = "id",
          ignore = true
    )
    User toModel(AddUserCommand command);

    @Mapping(
          target = "id",
          source = "userId.id"
    )
    UserId toUserId(DeleteUserCommand command);

    UserIdDto toUserIdDto(UserId userId);

    UserId toUserId(UserIdDto userIdDto);

    UserDto toUserDto(User user);

}
