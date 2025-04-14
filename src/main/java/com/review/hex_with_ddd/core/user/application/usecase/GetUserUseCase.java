package com.review.hex_with_ddd.core.user.application.usecase;

import com.review.hex_with_ddd.core.user.application.command.GetUserQuery;
import com.review.hex_with_ddd.core.user.application.dto.UserDto;

public interface GetUserUseCase {

    UserDto execute(GetUserQuery query);

}
