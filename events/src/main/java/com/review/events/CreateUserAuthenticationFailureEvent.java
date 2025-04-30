package com.review.events;

import java.util.UUID;

public record CreateUserAuthenticationFailureEvent(
      UUID userId,
      String reason
) {

}
