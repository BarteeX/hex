package com.review.hex_with_ddd.core.authentication.application.usecase;

import com.review.hex_with_ddd.core.authentication.application.command.AuthenticateUserCommand;
import com.review.hex_with_ddd.core.authentication.application.dto.AuthenticationUserTokenDto;

public interface AuthenticateUserUseCase {

    AuthenticationUserTokenDto execute(AuthenticateUserCommand query);

}
