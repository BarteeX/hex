package com.review.adapter.persistance.mapper;

import com.review.application.ValueObjectMapper;
import com.review.domain.ErrorMessage;
import com.review.domain.UserId;
import com.review.domain.model.UserAuthenticationState;
import com.review.domain.model.UserAuthenticationStateEvents;
import com.review.domain.model.UserAuthenticationStateStatus;
import com.review.infrastructure.db.UserAuthenticationStateHash;
import org.mapstruct.Mapper;

import java.util.Set;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
      componentModel = SPRING,
      uses = {
            ValueObjectMapper.class
      }
)
public interface UserAuthenticationStateHashMapper {

    UserAuthenticationStateProxy toDomain(UserAuthenticationStateHash hash);

    UserAuthenticationStateHash toHash(UserAuthenticationState domain);

    class UserAuthenticationStateProxy
          extends UserAuthenticationState {

        protected UserAuthenticationStateProxy(
              UserId userId,
              Set<UserAuthenticationStateStatus> status,
              UserAuthenticationStateEvents kind,
              ErrorMessage errorMessage
        ) {
            super(userId, status, kind, errorMessage);
        }

    }

}
