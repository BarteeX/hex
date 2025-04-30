package com.review.application.command;

import java.util.UUID;

public record NewUserCreatedCommand(
      UUID userId
) {

}
