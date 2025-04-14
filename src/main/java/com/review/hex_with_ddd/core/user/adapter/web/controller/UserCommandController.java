package com.review.hex_with_ddd.core.user.adapter.web.controller;

import com.review.hex_with_ddd.core.user.adapter.web.mapper.UserWebMapper;
import com.review.hex_with_ddd.core.user.adapter.web.request.AddUserRequest;
import com.review.hex_with_ddd.core.user.adapter.web.response.NewUserIdResponse;
import com.review.hex_with_ddd.core.user.application.command.AddUserCommand;
import com.review.hex_with_ddd.core.user.application.dto.UserIdDto;
import com.review.hex_with_ddd.core.user.application.usecase.AddUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserCommandController {

    private final AddUserUseCase addUser;

    private final UserWebMapper userWebMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewUserIdResponse addUser(
          @RequestBody AddUserRequest request
    ) {
        AddUserCommand command = userWebMapper.toCommand(request);
        UserIdDto userId = addUser.execute(command);
        return userWebMapper.toResponse(userId);
    }

}
