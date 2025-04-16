package com.review.hex_with_ddd.core.authentication.adapter.web.controller;

import com.review.hex_with_ddd.core.authentication.adapter.web.mapper.UserAuthenticationWebMapper;
import com.review.hex_with_ddd.core.authentication.adapter.web.request.LoginUserRequest;
import com.review.hex_with_ddd.core.authentication.adapter.web.request.RegisterUserRequest;
import com.review.hex_with_ddd.core.authentication.adapter.web.response.AuthenticationResponse;
import com.review.hex_with_ddd.core.authentication.application.command.AuthenticateUserCommand;
import com.review.hex_with_ddd.core.authentication.application.command.RegisterAuthenticationUserCommand;
import com.review.hex_with_ddd.core.authentication.application.dto.AuthenticationUserTokenDto;
import com.review.hex_with_ddd.core.authentication.application.usecase.AuthenticateUserUseCase;
import com.review.hex_with_ddd.core.authentication.application.usecase.RegisterAuthenticationUserUseCase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class UserAuthenticationCommandController {

    private final UserAuthenticationWebMapper userAuthenticationWebMapper;

    private final RegisterAuthenticationUserUseCase registerAuthenticationUserUseCase;

    private final AuthenticateUserUseCase authenticateUserUseCase;

    public UserAuthenticationCommandController(
          UserAuthenticationWebMapper userAuthenticationWebMapper,
          @Qualifier("registerAuthenticationUserUseCase") RegisterAuthenticationUserUseCase registerAuthenticationUserUseCase,
          @Qualifier("authenticateUserUseCase") AuthenticateUserUseCase authenticateUserUseCase
    ) {
        this.userAuthenticationWebMapper = userAuthenticationWebMapper;
        this.registerAuthenticationUserUseCase = registerAuthenticationUserUseCase;
        this.authenticateUserUseCase = authenticateUserUseCase;
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AuthenticationResponse registerUser(
          @RequestBody RegisterUserRequest registerUserRequest
    ) {
        RegisterAuthenticationUserCommand command = userAuthenticationWebMapper.toCommand(registerUserRequest);
        AuthenticationUserTokenDto authenticationUserTokenDto = registerAuthenticationUserUseCase.execute(command);
        return userAuthenticationWebMapper.toResponse(authenticationUserTokenDto);
    }


    @PostMapping("/login")
    public AuthenticationResponse login(
          @RequestBody LoginUserRequest loginUserRequest
    ) {
        AuthenticateUserCommand command = userAuthenticationWebMapper.toCommand(loginUserRequest);
        AuthenticationUserTokenDto authenticationUserTokenDto = authenticateUserUseCase.execute(command);
        return userAuthenticationWebMapper.toResponse(authenticationUserTokenDto);
    }

}
