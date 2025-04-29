package com.review.adapter.persistance.mapper;

import com.review.application.ValueObjectMapper;
import com.review.domain.model.AuthenticationUser;
import com.review.infrastructure.db.AuthenticationUserEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
      componentModel = SPRING,
      uses = {
            ValueObjectMapper.class
      }
)
public interface AuthenticationUserEntityMapper {

    AuthenticationUser toModel(AuthenticationUserEntity entity);

    AuthenticationUserEntity toEntity(AuthenticationUser authenticationUser);

}
