package com.review.domain;

import java.util.UUID;

public class UserId
      extends EntityId<UUID> {

    private UserId(UUID id) {
        super(id);
    }

    public static UserId of(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }

        return new UserId(id);
    }

    public static UserId random() {
        return new UserId(UUID.randomUUID());
    }

}
