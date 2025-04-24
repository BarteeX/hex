package com.review.application.command;

import com.review.application.dto.AuthenticationUserIdDto;

public record RegisterAuthenticationUserCommand(
      AuthenticationUserIdDto id,
      String password
) {

}
