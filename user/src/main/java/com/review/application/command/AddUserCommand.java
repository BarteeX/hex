package com.review.application.command;

public record AddUserCommand(
      String username,
      String firstName,
      String lastName
) {

}
