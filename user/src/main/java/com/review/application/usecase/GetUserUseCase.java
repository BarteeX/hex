package com.review.application.usecase;

import com.review.application.command.GetUserQuery;
import com.review.application.dto.UserDto;

public interface GetUserUseCase {

    UserDto execute(GetUserQuery query);

}
