package com.review.application.mapper;

import com.review.application.ValueObjectMapper;
import com.review.application.command.AddUserCommand;
import com.review.application.command.DeleteUserCommand;
import com.review.application.dto.UserDto;
import com.review.application.dto.UserIdDto;
import com.review.domain.UserId;
import com.review.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(uses = {ValueObjectMapper.class})
public interface UserMapper {

    @Mapping(
          target = "id",
          ignore = true
    )
    User toModel(AddUserCommand command);

    default UserId toUserId(DeleteUserCommand command) {
        UserIdDto userIdDto = command.userId();
        return toUserId(userIdDto);
    }

    @Mapping(
          source = "value",
          target = "id"
    )
    UserIdDto toUserIdDto(UserId userId);

    default UserId toUserId(UserIdDto userIdDto) {
        UUID id = userIdDto.id();
        return UserId.of(id);
    }

    UserDto toUserDto(User user);

}
