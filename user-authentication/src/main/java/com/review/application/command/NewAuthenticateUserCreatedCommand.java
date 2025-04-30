package com.review.application.command;

import java.util.UUID;

public record NewAuthenticateUserCreatedCommand(
      UUID userId
) {

}
