package com.review.adapter.web.mapper;

import com.review.adapter.web.request.LoginUserRequest;
import com.review.adapter.web.request.RegisterUserRequest;
import com.review.adapter.web.response.AuthenticationResponse;
import com.review.application.command.AuthenticateUserCommand;
import com.review.application.command.RegisterAuthenticationUserCommand;
import com.review.application.dto.AuthenticationUserTokenDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
      componentModel = SPRING
)
public interface UserAuthenticationWebMapper {

    @Mapping(
          target = "id.id",
          source = "userId"
    )
    RegisterAuthenticationUserCommand toCommand(RegisterUserRequest request);

    @Mapping(
          target = "id.id",
          source = "userId"
    )
    AuthenticateUserCommand toCommand(LoginUserRequest command);

    AuthenticationResponse toResponse(AuthenticationUserTokenDto dto);

}
