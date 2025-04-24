package com.review.adapter.web.request;

import java.util.UUID;

public record RegisterUserRequest(
      UUID userId,
      String password
) {

}
