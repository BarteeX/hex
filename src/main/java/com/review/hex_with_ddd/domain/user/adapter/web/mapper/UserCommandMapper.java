package com.review.hex_with_ddd.domain.user.adapter.web.mapper;

import com.review.hex_with_ddd.domain.user.adapter.web.request.AddUserRequest;
import com.review.hex_with_ddd.domain.user.adapter.web.response.NewUserIdResponse;
import com.review.hex_with_ddd.domain.user.application.command.AddUserCommand;
import com.review.hex_with_ddd.domain.user.application.dto.UserIdDto;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING
)
public interface UserCommandMapper {

    AddUserCommand toCommand(AddUserRequest request);

    NewUserIdResponse toResponse(UserIdDto userId);

}
