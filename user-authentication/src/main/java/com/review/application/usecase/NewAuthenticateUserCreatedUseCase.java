package com.review.application.usecase;

import com.review.application.command.NewAuthenticateUserCreatedCommand;

public interface NewAuthenticateUserCreatedUseCase {

    void execute(NewAuthenticateUserCreatedCommand command);

}
