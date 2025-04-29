package com.review.adapter.web.mapper;

import com.review.adapter.web.request.AddUserRequest;
import com.review.adapter.web.response.NewUserIdResponse;
import com.review.adapter.web.response.UserResponse;
import com.review.application.command.AddUserCommand;
import com.review.application.command.DeleteUserCommand;
import com.review.application.dto.UserDto;
import com.review.application.dto.UserIdDto;
import com.review.application.query.GetUserQuery;
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

    @Mapping(
          target = "userId.id",
          source = "uuid"
    )
    DeleteUserCommand toDeleteCommand(UUID uuid);

}
