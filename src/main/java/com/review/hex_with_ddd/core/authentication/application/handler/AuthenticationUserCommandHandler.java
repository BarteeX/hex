package com.review.hex_with_ddd.core.authentication.application.handler;

import com.review.hex_with_ddd.common.domain.UnitOfWork;
import com.review.hex_with_ddd.core.authentication.application.command.AuthenticateUserCommand;
import com.review.hex_with_ddd.core.authentication.application.command.RegisterAuthenticationUserCommand;
import com.review.hex_with_ddd.core.authentication.application.dto.AuthenticationUserTokenDto;
import com.review.hex_with_ddd.core.authentication.application.exception.AuthenticationUserException;
import com.review.hex_with_ddd.core.authentication.application.mapper.AuthenticationUserMapper;
import com.review.hex_with_ddd.core.authentication.application.usecase.AuthenticateUserUseCase;
import com.review.hex_with_ddd.core.authentication.application.usecase.RegisterAuthenticationUserUseCase;
import com.review.hex_with_ddd.core.authentication.domain.model.AuthenticationUser;
import com.review.hex_with_ddd.core.authentication.domain.model.AuthenticationUserToken;
import com.review.hex_with_ddd.core.authentication.domain.service.AuthenticationTokenService;
import com.review.hex_with_ddd.core.authentication.domain.service.AuthenticationUserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthenticationUserCommandHandler
      implements RegisterAuthenticationUserUseCase, AuthenticateUserUseCase {

    private final UnitOfWork unitOfWork;

    private final AuthenticationUserMapper userMapper;

    private final AuthenticationUserService userService;

    private final AuthenticationTokenService tokenService;

    @Override
    public AuthenticationUserTokenDto execute(AuthenticateUserCommand query) {
        AuthenticationUser user = userMapper.toModel(query);
        boolean passwordValid = userService.isPasswordValid(user);
        if (!passwordValid) {
            throw new AuthenticationUserException();
        }

        AuthenticationUserToken token = tokenService.createToken(user);
        return userMapper.toDto(token);
    }


    @Override
    public AuthenticationUserTokenDto execute(RegisterAuthenticationUserCommand command) {
        return unitOfWork.run(() -> {
            AuthenticationUser newUser = userMapper.toModel(command);
            AuthenticationUser user = userService.createUser(newUser);
            AuthenticationUserToken token = tokenService.createToken(user);
            return userMapper.toDto(token);
        });
    }

}
