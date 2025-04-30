package com.review.domain.port;

import com.review.domain.*;

public interface UserAuthenticationEventEmitter {

    void emitCreateUser(
          UserId userId,
          Username username,
          FirstName firstName,
          LastName lastName
    );

    void emitCreateAuthenticateUser(
          UserId userId,
          Password password
    );

}
