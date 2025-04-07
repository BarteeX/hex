package com.review.hex_with_ddd.domain.user.adapter.web.request;

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
