package com.review.application.usecase;

import com.review.application.command.RegisterAuthenticationUserCommand;
import com.review.application.dto.AuthenticationUserTokenDto;

public interface RegisterAuthenticationUserUseCase {

    AuthenticationUserTokenDto execute(RegisterAuthenticationUserCommand command);

}
