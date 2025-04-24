package com.review.application.usecase;

import com.review.application.command.AddUserCommand;
import com.review.application.dto.UserIdDto;

public interface AddUserUseCase {

    UserIdDto execute(AddUserCommand command);

}
