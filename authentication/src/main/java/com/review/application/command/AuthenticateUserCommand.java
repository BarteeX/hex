package com.review.application.command;

import com.review.application.dto.AuthenticationUserIdDto;

public record AuthenticateUserCommand(
      AuthenticationUserIdDto id,
      String password
) {

}
