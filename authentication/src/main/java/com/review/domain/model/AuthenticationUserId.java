package com.review.domain.model;


import com.review.domain.EntityId;

import java.util.UUID;

public class AuthenticationUserId
      extends EntityId<UUID> {

    public AuthenticationUserId(UUID id) {
        super(id);
    }

}
