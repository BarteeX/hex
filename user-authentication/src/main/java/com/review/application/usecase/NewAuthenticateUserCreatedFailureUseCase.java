package com.review.application.usecase;

import com.review.application.command.NewAuthenticateUserCreatedFailureCommand;

public interface NewAuthenticateUserCreatedFailureUseCase {

    void execute(NewAuthenticateUserCreatedFailureCommand command);

}
