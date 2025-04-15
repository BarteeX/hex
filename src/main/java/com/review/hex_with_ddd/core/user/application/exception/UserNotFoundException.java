package com.review.hex_with_ddd.core.user.application.exception;

import com.review.hex_with_ddd.core.user.application.dto.UserIdDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserNotFoundException
      extends IllegalArgumentException {

    private final UserIdDto userId;

}
