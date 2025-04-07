package com.review.hex_with_ddd.domain.user.adapter.web.response;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Jacksonized
@Builder
public record NewUserIdResponse(
        UUID id
) {

}
