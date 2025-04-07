package com.review.hex_with_ddd.domain.user.application.mapper;

import com.review.hex_with_ddd.domain.user.application.command.AddUserCommand;
import com.review.hex_with_ddd.domain.user.application.dto.UserIdDto;
import com.review.hex_with_ddd.domain.user.domain.model.User;
import com.review.hex_with_ddd.domain.user.domain.model.UserId;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING
)
public interface UserMapper {

    User toModel(AddUserCommand command);

    UserIdDto toUserIdDto(UserId userId);

}
