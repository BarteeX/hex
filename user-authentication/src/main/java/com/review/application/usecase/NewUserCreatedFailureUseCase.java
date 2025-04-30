package com.review.application.usecase;

import com.review.application.command.NewUserCreatedFailureCommand;

public interface NewUserCreatedFailureUseCase {

    void execute(NewUserCreatedFailureCommand command);

}
