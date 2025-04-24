package com.review.application.mapper;

import com.review.application.command.AddUserCommand;
import com.review.application.command.DeleteUserCommand;
import com.review.application.dto.UserDto;
import com.review.application.dto.UserIdDto;
import com.review.domain.model.User;
import com.review.domain.model.UserId;
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
