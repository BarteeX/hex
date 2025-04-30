package com.review.application.dto;

import java.util.UUID;

public record UserAuthenticationStateDto(
      UUID userId,
      boolean completed,
      boolean error,
      String errorMessage
) {

}
