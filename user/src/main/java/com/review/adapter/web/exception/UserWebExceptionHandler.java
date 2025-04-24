package com.review.adapter.web.exception;

import com.review.adapter.web.controller.UserCommandController;
import com.review.adapter.web.controller.UserQueryController;
import com.review.application.dto.UserIdDto;
import com.review.application.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ControllerAdvice(
      assignableTypes = {
            UserCommandController.class,
            UserQueryController.class
      }
)
public class UserWebExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handlerUserNotFoundException(
          UserNotFoundException exception
    ) {
        String messageTemplate = "User with id = [%s] not exists";
        UserIdDto userId = exception.getUserId();
        UUID id = userId.id();

        String message = messageTemplate.formatted(id.toString());
        return new ErrorResponse(message);
    }


    public record ErrorResponse(
          String message
    ) {

    }

}
