package com.review.hex_with_ddd.core.user.adapter.web.mapper;

import com.review.hex_with_ddd.core.user.adapter.web.request.AddUserRequest;
import com.review.hex_with_ddd.core.user.adapter.web.response.NewUserIdResponse;
import com.review.hex_with_ddd.core.user.adapter.web.response.UserResponse;
import com.review.hex_with_ddd.core.user.application.command.AddUserCommand;
import com.review.hex_with_ddd.core.user.application.command.GetUserQuery;
import com.review.hex_with_ddd.core.user.application.dto.UserDto;
import com.review.hex_with_ddd.core.user.application.dto.UserIdDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
      componentModel = SPRING
)
public interface UserWebMapper {

    AddUserCommand toCommand(AddUserRequest request);

    NewUserIdResponse toResponse(UserIdDto userId);

    UserResponse toResponse(UserDto user);

    @Mapping(
          target = "userId.id",
          source = "uuid"
    )
    GetUserQuery toQuery(UUID uuid);

}
