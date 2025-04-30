package com.review.adapter.event.listener;

import com.review.adapter.event.mapper.UserAuthenticationEventMapper;
import com.review.application.command.NewAuthenticateUserCreatedCommand;
import com.review.application.command.NewAuthenticateUserCreatedFailureCommand;
import com.review.application.command.NewUserCreatedCommand;
import com.review.application.command.NewUserCreatedFailureCommand;
import com.review.application.usecase.NewAuthenticateUserCreatedFailureUseCase;
import com.review.application.usecase.NewAuthenticateUserCreatedUseCase;
import com.review.application.usecase.NewUserCreatedFailureUseCase;
import com.review.application.usecase.NewUserCreatedUseCase;
import com.review.events.CreateUserAuthenticationFailureEvent;
import com.review.events.CreateUserAuthenticationSuccessEvent;
import com.review.events.CreateUserFailureEvent;
import com.review.events.CreateUserSuccessEvent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class UserAuthenticationEventListenerAdapter {

    private final NewUserCreatedUseCase newUserCreatedUseCase;

    private final NewUserCreatedFailureUseCase newUserCreatedFailureUseCase;

    private final NewAuthenticateUserCreatedUseCase newAuthenticateUserCreatedUseCase;

    private final NewAuthenticateUserCreatedFailureUseCase newAuthenticateUserCreatedFailureUseCase;

    private final UserAuthenticationEventMapper userAuthenticationEventMapper;

    public UserAuthenticationEventListenerAdapter(
          @Qualifier("newUserCreatedUseCase") NewUserCreatedUseCase newUserCreatedUseCase,
          @Qualifier("newUserCreatedFailureUseCase") NewUserCreatedFailureUseCase newUserCreatedFailureUseCase,
          @Qualifier("newAuthenticateUserCreatedUseCase") NewAuthenticateUserCreatedUseCase newAuthenticateUserCreatedUseCase,
          @Qualifier("newAuthenticateUserCreatedFailureUseCase") NewAuthenticateUserCreatedFailureUseCase newAuthenticateUserCreatedFailureUseCase,
          UserAuthenticationEventMapper userAuthenticationEventMapper
    ) {
        this.newUserCreatedUseCase = newUserCreatedUseCase;
        this.newUserCreatedFailureUseCase = newUserCreatedFailureUseCase;
        this.newAuthenticateUserCreatedUseCase = newAuthenticateUserCreatedUseCase;
        this.newAuthenticateUserCreatedFailureUseCase = newAuthenticateUserCreatedFailureUseCase;
        this.userAuthenticationEventMapper = userAuthenticationEventMapper;
    }

    @TransactionalEventListener
    public void onCreateUserSuccessEvent(CreateUserSuccessEvent event) {
        NewUserCreatedCommand command = userAuthenticationEventMapper.toCommand(event);
        newUserCreatedUseCase.execute(command);
    }

    @TransactionalEventListener
    public void onCreateUserSuccessEvent(CreateUserFailureEvent event) {
        NewUserCreatedFailureCommand command = userAuthenticationEventMapper.toCommand(event);
        newUserCreatedFailureUseCase.execute(command);
    }

    @TransactionalEventListener
    public void onCreateUserAuthenticationSuccessEvent(CreateUserAuthenticationSuccessEvent event) {
        NewAuthenticateUserCreatedCommand command = userAuthenticationEventMapper.toCommand(event);
        newAuthenticateUserCreatedUseCase.execute(command);
    }

    @TransactionalEventListener
    public void onCreateUserAuthenticationFailureEvent(CreateUserAuthenticationFailureEvent event) {
        NewAuthenticateUserCreatedFailureCommand command = userAuthenticationEventMapper.toCommand(event);
        newAuthenticateUserCreatedFailureUseCase.execute(command);
    }

}
