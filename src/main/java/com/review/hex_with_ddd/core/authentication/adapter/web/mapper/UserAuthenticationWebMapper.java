package com.review.hex_with_ddd.core.authentication.adapter.web.mapper;

import com.review.hex_with_ddd.core.authentication.adapter.web.request.LoginUserRequest;
import com.review.hex_with_ddd.core.authentication.adapter.web.request.RegisterUserRequest;
import com.review.hex_with_ddd.core.authentication.adapter.web.response.AuthenticationResponse;
import com.review.hex_with_ddd.core.authentication.application.command.AuthenticateUserCommand;
import com.review.hex_with_ddd.core.authentication.application.command.RegisterAuthenticationUserCommand;
import com.review.hex_with_ddd.core.authentication.application.dto.AuthenticationUserTokenDto;
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
