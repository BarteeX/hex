package com.review.application.command;

import java.util.UUID;

public record NewUserCreatedFailureCommand(
      UUID userId
) {

}
