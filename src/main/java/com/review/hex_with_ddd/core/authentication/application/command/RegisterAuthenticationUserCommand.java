package com.review.hex_with_ddd.core.authentication.application.command;

import com.review.hex_with_ddd.core.authentication.application.dto.AuthenticationUserIdDto;

public record RegisterAuthenticationUserCommand(
      AuthenticationUserIdDto id,
      String password
) {

}
