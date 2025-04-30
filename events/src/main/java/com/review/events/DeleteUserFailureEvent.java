package com.review.events;

import java.util.UUID;

public record DeleteUserFailureEvent(
      UUID userId,
      String reason
) {

}
