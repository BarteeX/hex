package com.review.application.usecase;

import com.review.application.command.DeleteUserCommand;

public interface DeleteUserUseCase {

    void execute(DeleteUserCommand command);

}
