package com.review.hex_with_ddd.core.authentication.adapter.web.request;

import java.util.UUID;

public record LoginUserRequest(
      UUID userId,
      String password
) {

}
