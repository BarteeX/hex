package com.review.application.usecase;

import com.review.application.dto.UserAuthenticationStateDto;
import com.review.application.query.GetNewUserStatusQuery;

public interface GetNewUserStatusUseCase {

    UserAuthenticationStateDto execute(GetNewUserStatusQuery query);

}
