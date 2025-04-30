package com.review.application.handler;

import com.review.application.command.*;
import com.review.application.exception.NewUserStatusNotExistsException;
import com.review.application.usecase.*;
import com.review.domain.*;
import com.review.domain.model.UserAuthenticationState;
import com.review.domain.port.UserAuthenticationEventEmitter;
import com.review.domain.repository.UserAuthenticationStateRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class UserActionCommandHandler
      implements CreateNewUserActionUseCase, NewUserCreatedUseCase,
      NewUserCreatedFailureUseCase, NewAuthenticateUserCreatedUseCase, NewAuthenticateUserCreatedFailureUseCase {

    private final UserAuthenticationEventEmitter eventEmitter;

    private final UserAuthenticationStateRepository stateRepository;

    private final UnitOfWork unitOfWork;

    @Override
    public UUID execute(StartUserCreateActionCommand command) {
        UserId userId = UserId.random();
        Username username = Username.of(command.username());
        FirstName firstName = FirstName.of(command.firstName());
        LastName lastName = LastName.of(command.lastName());
        Password password = Password.of(command.password());

        eventEmitter.emitCreateUser(
              userId,
              username,
              firstName,
              lastName
        );

        eventEmitter.emitCreateAuthenticateUser(
              userId,
              password
        );

        unitOfWork.run(() -> {
            UserAuthenticationState state = UserAuthenticationState.forNewUser(userId);
            stateRepository.save(state);
        });

        return userId.getValue();
    }

    @Override
    public void execute(NewUserCreatedCommand command) {
        UserId userId = UserId.of(command.userId());
        updateStatus(userId, UserAuthenticationState::userCreated);
    }

    @Override
    public void execute(NewUserCreatedFailureCommand command) {
        UserId userId = UserId.of(command.userId());
        updateStatus(userId, UserAuthenticationState::userCreatedFailure);
    }

    @Override
    public void execute(NewAuthenticateUserCreatedCommand command) {
        UserId userId = UserId.of(command.userId());
        updateStatus(userId, UserAuthenticationState::authenticated);
    }

    @Override
    public void execute(NewAuthenticateUserCreatedFailureCommand command) {
        UserId userId = UserId.of(command.userId());
        updateStatus(userId, UserAuthenticationState::authenticatedFailure);
    }

    private void updateStatus(UserId userId, Consumer<UserAuthenticationState> consumer) {
        unitOfWork.run(
              () -> stateRepository.findByUserId(userId)
                    .ifPresentOrElse(
                          state -> {
                              consumer.accept(state);
                              stateRepository.save(state);
                          },
                          () -> {
                              throw NewUserStatusNotExistsException.of(userId);
                          }
                    )
        );
    }

}
