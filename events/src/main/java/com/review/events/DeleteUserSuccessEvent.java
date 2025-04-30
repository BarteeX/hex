package com.review.events;

import java.util.UUID;

public record DeleteUserSuccessEvent(
      UUID userId
) {

}
