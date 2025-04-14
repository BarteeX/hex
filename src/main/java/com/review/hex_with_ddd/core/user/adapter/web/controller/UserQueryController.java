package com.review.hex_with_ddd.core.user.adapter.web.controller;

import com.review.hex_with_ddd.core.user.adapter.web.mapper.UserWebMapper;
import com.review.hex_with_ddd.core.user.adapter.web.response.UserResponse;
import com.review.hex_with_ddd.core.user.application.command.GetUserQuery;
import com.review.hex_with_ddd.core.user.application.dto.UserDto;
import com.review.hex_with_ddd.core.user.application.usecase.GetUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserQueryController {

    private final UserWebMapper userWebMapper;

    private final GetUserUseCase getUserUseCase;

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUser(
          @PathVariable("userId") UUID userId
    ) {
        GetUserQuery query = userWebMapper.toQuery(userId);
        UserDto user = getUserUseCase.execute(query);
        return userWebMapper.toResponse(user);
    }

}
