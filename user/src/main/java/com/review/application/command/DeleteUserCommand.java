package com.review.application.command;

import com.review.application.dto.UserIdDto;

public record DeleteUserCommand(
      UserIdDto userId
) {

}
