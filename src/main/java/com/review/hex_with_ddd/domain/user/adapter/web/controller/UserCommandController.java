package com.review.hex_with_ddd.domain.user.adapter.web.controller;

import com.review.hex_with_ddd.domain.user.adapter.web.mapper.UserCommandMapper;
import com.review.hex_with_ddd.domain.user.adapter.web.request.AddUserRequest;
import com.review.hex_with_ddd.domain.user.adapter.web.response.NewUserIdResponse;
import com.review.hex_with_ddd.domain.user.application.command.AddUserCommand;
import com.review.hex_with_ddd.domain.user.application.dto.UserIdDto;
import com.review.hex_with_ddd.domain.user.application.usecase.AddUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserCommandController {

    private final AddUserUseCase addUser;

    private final UserCommandMapper userCommandMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewUserIdResponse addUser(AddUserRequest request) {
        AddUserCommand command = userCommandMapper.toCommand(request);
        UserIdDto userId = addUser.execute(command);
        return userCommandMapper.toResponse(userId);
    }

}
