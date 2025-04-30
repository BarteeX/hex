package com.review.events;

import java.util.UUID;

public record CreateUserEvent(
      UUID userId,
      String username,
      String firstName,
      String lastName
) {


}