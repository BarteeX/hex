package com.review.events;

import java.util.UUID;

public record CreateUserAuthenticationSuccessEvent(
      UUID userId
) {

}
