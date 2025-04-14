package com.review.hex_with_ddd.core.user.application.usecase;

import com.review.hex_with_ddd.core.user.application.command.AddUserCommand;
import com.review.hex_with_ddd.core.user.application.dto.UserIdDto;

public interface AddUserUseCase {

    UserIdDto execute(AddUserCommand command);

}
