package com.review.application.command;

public record StartUserCreateActionCommand(
      String username,
      String firstName,
      String lastName,
      String password
) {

}
