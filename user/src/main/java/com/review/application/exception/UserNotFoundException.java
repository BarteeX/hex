package com.review.application.exception;

import com.review.application.dto.UserIdDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserNotFoundException
      extends IllegalArgumentException {

    private final UserIdDto userId;

}
