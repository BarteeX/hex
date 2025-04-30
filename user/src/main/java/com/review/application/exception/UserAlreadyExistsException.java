package com.review.application.exception;

import com.review.domain.Username;

public class UserAlreadyExistsException
      extends IllegalArgumentException {

    private UserAlreadyExistsException(Username username) {
        super("User with username " + username.getValue() + " already exists");
    }

    public static UserAlreadyExistsException of(Username username) {
        return new UserAlreadyExistsException(username);
    }

}
