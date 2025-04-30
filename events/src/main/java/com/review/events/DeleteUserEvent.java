package com.review.events;

import java.util.UUID;

public record DeleteUserEvent(
      UUID userId
) {

}
