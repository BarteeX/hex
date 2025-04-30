package com.review.application.usecase;

import com.review.application.command.StartUserCreateActionCommand;

import java.util.UUID;

public interface CreateNewUserActionUseCase {

    UUID execute(StartUserCreateActionCommand command);

}
