package com.review.adapter.web.request;

import java.util.UUID;

public record LoginUserRequest(
      UUID userId,
      String password
) {

}
