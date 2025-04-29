package com.review.application.usecase;

import com.review.application.dto.UserDto;
import com.review.application.query.GetUserQuery;

public interface GetUserUseCase {

    UserDto execute(GetUserQuery query);

}
