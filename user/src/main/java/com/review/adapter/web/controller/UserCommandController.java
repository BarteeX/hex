package com.review.adapter.web.controller;

import com.review.adapter.web.mapper.UserWebMapper;
import com.review.adapter.web.request.AddUserRequest;
import com.review.adapter.web.response.NewUserIdResponse;
import com.review.application.command.AddUserCommand;
import com.review.application.command.DeleteUserCommand;
import com.review.application.dto.UserIdDto;
import com.review.application.usecase.AddUserUseCase;
import com.review.application.usecase.DeleteUserUseCase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserCommandController {

    private final AddUserUseCase addUser;

    private final DeleteUserUseCase deleteUser;

    private final UserWebMapper userWebMapper;

    public UserCommandController(
          @Qualifier("addUserUseCase") AddUserUseCase addUser,
          @Qualifier("deleteUserUseCase") DeleteUserUseCase deleteUser,
          UserWebMapper userWebMapper
    ) {
        this.addUser = addUser;
        this.deleteUser = deleteUser;
        this.userWebMapper = userWebMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewUserIdResponse add(
          @RequestBody AddUserRequest request
    ) {
        AddUserCommand command = userWebMapper.toCommand(request);
        UserIdDto userId = addUser.execute(command);
        return userWebMapper.toResponse(userId);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
          @PathVariable("userId") UUID userId
    ) {
        DeleteUserCommand command = userWebMapper.toDeleteCommand(userId);
        deleteUser.execute(command);
    }

}
