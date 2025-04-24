package com.review.adapter.out.mapper;

import com.review.domain.model.User;
import com.review.domain.model.UserId;
import com.review.infrastructure.db.entity.UserDB;
import org.mapstruct.Mapper;

import java.util.UUID;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
      componentModel = SPRING
)
public interface UserDBMapper {

    UserId toModelId(UserDB userEntity);

    User toModel(UserDB userEntity);

    UserDB toDbModel(User user);

    default UUID toUUID(UserId userId) {
        return userId.getId();
    }

}
