package com.review.application.usecase;

import com.review.application.command.NewUserCreatedCommand;

public interface NewUserCreatedUseCase {

    void execute(NewUserCreatedCommand command);

}
