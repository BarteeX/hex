package com.review.events;

import java.util.UUID;

public record CreateAuthenticateUserEvent(
      UUID uuid,
      String password
) {

}
