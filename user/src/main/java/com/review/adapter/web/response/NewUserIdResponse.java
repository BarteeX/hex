package com.review.adapter.web.response;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Jacksonized
@Builder
public record NewUserIdResponse(
      UUID id
) {

}
