package com.review.hex_with_ddd.core.user.application.command;

import com.review.hex_with_ddd.core.user.application.dto.UserIdDto;

public record GetUserQuery(
      UserIdDto userId
) {

}
