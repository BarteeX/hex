package com.review.adapter.persistance.mapper;

import com.review.domain.model.AuthenticationUser;
import com.review.infrastructure.db.AuthenticationUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
      componentModel = SPRING
)
public interface AuthenticationUserEntityMapper {

    @Mapping(
          target = "id.id",
          source = "id"
    )
    AuthenticationUser toModel(AuthenticationUserEntity entity);

    @Mapping(
          target = "id",
          source = "id.id"
    )
    AuthenticationUserEntity toEntity(AuthenticationUser authenticationUser);

}
