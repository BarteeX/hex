package com.review.application.exception;

import com.review.domain.UserId;

public class NewUserStatusNotExistsException
      extends IllegalArgumentException {

    private NewUserStatusNotExistsException(UserId userId) {
        super("New user status not exists for user ID: " + userId);
    }

    public static NewUserStatusNotExistsException of(UserId userId) {
        return new NewUserStatusNotExistsException(userId);
    }

}
