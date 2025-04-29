package com.review.adapter.web.exception;

import com.review.adapter.web.controller.UserAuthenticationCommandController;
import com.review.application.exception.AuthenticationUserException;
import com.review.domain.exception.PasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(
      assignableTypes = {
            UserAuthenticationCommandController.class
      }
)
public class UserAuthenticationWebExceptionHandler {

    @ExceptionHandler({AuthenticationUserException.class, PasswordException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorResponse handlerAuthenticationUserException(
          IllegalArgumentException ignored
    ) {
        String message = "Authentication failed";
        return new ErrorResponse(message);
    }


    public record ErrorResponse(
          String message
    ) {

    }

}
