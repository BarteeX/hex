package com.review.hex_with_ddd.core.authentication.application.usecase;

import com.review.hex_with_ddd.core.authentication.application.command.RegisterAuthenticationUserCommand;
import com.review.hex_with_ddd.core.authentication.application.dto.AuthenticationUserTokenDto;

public interface RegisterAuthenticationUserUseCase {

    AuthenticationUserTokenDto execute(RegisterAuthenticationUserCommand command);

}
