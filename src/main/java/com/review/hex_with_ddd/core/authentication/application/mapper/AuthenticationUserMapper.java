package com.review.hex_with_ddd.core.authentication.application.mapper;

import com.review.hex_with_ddd.core.authentication.application.command.AuthenticateUserCommand;
import com.review.hex_with_ddd.core.authentication.application.command.RegisterAuthenticationUserCommand;
import com.review.hex_with_ddd.core.authentication.application.dto.AuthenticationUserTokenDto;
import com.review.hex_with_ddd.core.authentication.domain.model.AuthenticationUser;
import com.review.hex_with_ddd.core.authentication.domain.model.AuthenticationUserToken;
import org.mapstruct.Mapper;

@Mapper
public interface AuthenticationUserMapper {

    AuthenticationUser toModel(RegisterAuthenticationUserCommand command);

    AuthenticationUser toModel(AuthenticateUserCommand query);

    AuthenticationUserTokenDto toDto(AuthenticationUserToken model);

}
