package com.review.domain.model;

import com.review.domain.EntityId;

import java.util.UUID;

public class UserId
      extends EntityId<UUID> {

    public UserId(UUID id) {
        super(id);
    }

}
