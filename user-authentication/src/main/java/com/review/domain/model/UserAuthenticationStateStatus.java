package com.review.domain.model;

import java.util.List;

public enum UserAuthenticationStateStatus {

    STARTED,
    USER_CREATED,
    USER_CREATION_FAILED,
    AUTHENTICATION_CREATED,
    AUTHENTICATION_FAILED,
    ;

    public static final List<UserAuthenticationStateStatus> SUCCESS_VALUES =
          List.of(STARTED, USER_CREATED, AUTHENTICATION_CREATED);

    public boolean isError() {
        return switch (this) {
            case STARTED, AUTHENTICATION_CREATED, USER_CREATED -> false;
            case USER_CREATION_FAILED, AUTHENTICATION_FAILED -> true;
        };
    }

}
