package com.review.adapter.event.emitter;

import com.review.domain.*;
import com.review.domain.port.UserAuthenticationEventEmitter;
import com.review.events.CreateAuthenticateUserEvent;
import com.review.events.CreateUserEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class UserAuthenticationEventEmitterAdapter
      implements UserAuthenticationEventEmitter {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void emitCreateUser(UserId userId, Username username, FirstName firstName, LastName lastName) {
        CreateUserEvent event = new CreateUserEvent(
              userId.getValue(),
              username.getValue(),
              firstName.getValue(),
              lastName.getValue()
        );

        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void emitCreateAuthenticateUser(UserId userId, Password password) {
        CreateAuthenticateUserEvent event = new CreateAuthenticateUserEvent(
              userId.getValue(),
              password.getValue()
        );

        applicationEventPublisher.publishEvent(event);
    }

}
