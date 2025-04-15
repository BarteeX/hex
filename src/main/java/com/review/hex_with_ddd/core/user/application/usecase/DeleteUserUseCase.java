package com.review.hex_with_ddd.core.user.application.usecase;

import com.review.hex_with_ddd.core.user.application.command.DeleteUserCommand;

public interface DeleteUserUseCase {

    void execute(DeleteUserCommand command);

}
