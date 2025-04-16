package com.review.hex_with_ddd.core.authentication.adapter.web.exception;

import com.review.hex_with_ddd.core.authentication.adapter.web.controller.UserAuthenticationCommandController;
import com.review.hex_with_ddd.core.authentication.application.exception.AuthenticationUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(
      assignableTypes = {
            UserAuthenticationWebExceptionHandler.class,
            UserAuthenticationCommandController.class
      }
)
public class UserAuthenticationWebExceptionHandler {

    @ExceptionHandler(AuthenticationUserException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorResponse handlerAuthenticationUserException(
          AuthenticationUserException ignored
    ) {
        String message = "Authentication failed";
        return new ErrorResponse(message);
    }


    public record ErrorResponse(
          String message
    ) {

    }

}
