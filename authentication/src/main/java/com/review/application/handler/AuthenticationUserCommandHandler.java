package com.review.application.handler;

import com.review.application.command.AuthenticateUserCommand;
import com.review.application.command.RegisterAuthenticationUserCommand;
import com.review.application.dto.AuthenticationUserTokenDto;
import com.review.application.exception.AuthenticationUserException;
import com.review.application.mapper.AuthenticationUserMapper;
import com.review.application.usecase.AuthenticateUserUseCase;
import com.review.application.usecase.RegisterAuthenticationUserUseCase;
import com.review.domain.UnitOfWork;
import com.review.domain.model.AuthenticationUser;
import com.review.domain.model.AuthenticationUserToken;
import com.review.domain.service.AuthenticationTokenService;
import com.review.domain.service.AuthenticationUserService;
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
