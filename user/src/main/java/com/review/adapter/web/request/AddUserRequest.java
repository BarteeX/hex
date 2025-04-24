package com.review.adapter.web.request;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record AddUserRequest(
      String username,
      String firstName,
      String lastName
) {

}
