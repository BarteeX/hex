package com.review.hex_with_ddd.core.user.application.command;

public record AddUserCommand(
      String username,
      String firstName,
      String lastName
) {

}
