package com.review.hex_with_ddd.domain.user.adapter.out.mapper;

import com.review.hex_with_ddd.domain.user.domain.model.User;
import com.review.hex_with_ddd.domain.user.domain.model.UserId;
import com.review.hex_with_ddd.domain.user.infrastructure.adapter.model.UserDB;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING
)
public interface UserDBMapper {

    UserId toModel(UserDB userEntity);

    UserDB toDbModel(User user);

}
