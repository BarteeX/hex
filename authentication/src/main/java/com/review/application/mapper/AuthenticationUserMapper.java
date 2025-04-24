package com.review.application.mapper;

import com.review.application.command.AuthenticateUserCommand;
import com.review.application.command.RegisterAuthenticationUserCommand;
import com.review.application.dto.AuthenticationUserTokenDto;
import com.review.domain.model.AuthenticationUser;
import com.review.domain.model.AuthenticationUserToken;
import org.mapstruct.Mapper;

@Mapper
public interface AuthenticationUserMapper {

    AuthenticationUser toModel(RegisterAuthenticationUserCommand command);

    AuthenticationUser toModel(AuthenticateUserCommand query);

    AuthenticationUserTokenDto toDto(AuthenticationUserToken model);

}
