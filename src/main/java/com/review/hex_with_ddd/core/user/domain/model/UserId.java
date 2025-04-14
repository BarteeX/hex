package com.review.hex_with_ddd.core.user.domain.model;

import com.review.hex_with_ddd.common.domain.EntityId;

import java.util.UUID;

public class UserId
      extends EntityId<UUID> {

    public UserId(UUID id) {
        super(id);
    }

}
