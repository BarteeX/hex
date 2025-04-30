package com.review.events;

import java.util.UUID;

public record CreateUserSuccessEvent(
      UUID userId
) {

}
