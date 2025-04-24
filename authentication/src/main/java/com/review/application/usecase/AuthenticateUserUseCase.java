package com.review.application.usecase;

import com.review.application.command.AuthenticateUserCommand;
import com.review.application.dto.AuthenticationUserTokenDto;

public interface AuthenticateUserUseCase {

    AuthenticationUserTokenDto execute(AuthenticateUserCommand query);

}
