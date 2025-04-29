package com.review.adapter.out.mapper;

import com.review.application.ValueObjectMapper;
import com.review.domain.UserId;
import com.review.domain.model.User;
import com.review.infrastructure.db.entity.UserDB;
import org.mapstruct.Mapper;

import java.util.UUID;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
      componentModel = SPRING,
      uses = {
            ValueObjectMapper.class,
      }
)
public interface UserDBMapper {

    default UserId toModelId(UserDB userEntity) {
        UUID id = userEntity.getId();
        return UserId.of(id);
    }

    User toModel(UserDB userEntity);

    UserDB toDbModel(User user);

    default UUID toUUID(UserId userId) {
        return userId.getValue();
    }

}
