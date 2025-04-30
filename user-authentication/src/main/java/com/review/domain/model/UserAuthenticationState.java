package com.review.domain.model;

import com.review.domain.ErrorMessage;
import com.review.domain.UserId;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Getter
public class UserAuthenticationState {

    private final UserId userId;

    private final Set<UserAuthenticationStateStatus> status;

    private final UserAuthenticationStateEvents kind;

    @Setter
    private ErrorMessage errorMessage;

    protected UserAuthenticationState(
          UserId userId,
          Set<UserAuthenticationStateStatus> status,
          UserAuthenticationStateEvents kind,
          ErrorMessage errorMessage
    ) {
        this.userId = userId;
        this.status = status;
        this.kind = kind;
        this.errorMessage = errorMessage;
    }

    private UserAuthenticationState(UserId userId, UserAuthenticationStateEvents kind) {
        this(
              userId,
              new TreeSet<>(List.of(UserAuthenticationStateStatus.STARTED)),
              kind,
              ErrorMessage.empty()
        );
    }

    public static UserAuthenticationState forNewUser(
          UserId userId
    ) {
        return new UserAuthenticationState(userId, UserAuthenticationStateEvents.NEW_USER);
    }

    public void userCreated() {
        this.status.add(UserAuthenticationStateStatus.USER_CREATED);
    }

    public void userCreatedFailure() {
        this.status.add(UserAuthenticationStateStatus.USER_CREATION_FAILED);
    }

    public void authenticated() {
        this.status.add(UserAuthenticationStateStatus.AUTHENTICATION_CREATED);
    }

    public void authenticatedFailure() {
        this.status.add(UserAuthenticationStateStatus.AUTHENTICATION_FAILED);
    }

    public boolean isCompleted() {
        List<UserAuthenticationStateStatus> successValues = UserAuthenticationStateStatus.SUCCESS_VALUES;
        return status.size() == successValues.size() && status.containsAll(successValues);
    }

    public boolean isError() {
        return this.status.stream()
              .anyMatch(UserAuthenticationStateStatus::isError);
    }

}
