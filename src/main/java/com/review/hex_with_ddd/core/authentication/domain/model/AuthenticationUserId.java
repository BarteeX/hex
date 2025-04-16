package com.review.hex_with_ddd.core.authentication.domain.model;


import com.review.hex_with_ddd.common.domain.EntityId;

import java.util.UUID;

public class AuthenticationUserId
      extends EntityId<UUID> {

    public AuthenticationUserId(UUID id) {
        super(id);
    }

}
