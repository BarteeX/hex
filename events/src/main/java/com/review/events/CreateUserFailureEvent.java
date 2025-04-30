package com.review.events;

import java.util.UUID;

public record CreateUserFailureEvent(
      UUID userId,
      String reason
) {

}
