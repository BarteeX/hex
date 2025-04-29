package com.review.application.mapper;

import com.review.application.ValueObjectMapper;
import com.review.application.command.AuthenticateUserCommand;
import com.review.application.command.RegisterAuthenticationUserCommand;
import com.review.application.dto.AuthenticationUserTokenDto;
import com.review.domain.model.AuthenticationUser;
import com.review.domain.model.AuthenticationUserToken;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
      uses = {
            ValueObjectMapper.class
      }
)
public interface AuthenticationUserMapper {

    @Mapping(
          target = "id",
          source = "id.id"
    )
    AuthenticationUser toModel(RegisterAuthenticationUserCommand command);

    @Mapping(
          target = "id",
          source = "id.id"
    )
    AuthenticationUser toModel(AuthenticateUserCommand query);

    AuthenticationUserTokenDto toDto(AuthenticationUserToken model);

}
