package com.review.application.mapper;

import com.review.application.ValueObjectMapper;
import com.review.application.dto.UserAuthenticationStateDto;
import com.review.application.query.GetNewUserStatusQuery;
import com.review.domain.UserId;
import com.review.domain.model.UserAuthenticationState;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
      uses = {
            ValueObjectMapper.class
      }
)
public interface UserAuthenticationStateMapper {

    @Mapping(
          target = "userId",
          source = "userId.value"
    )
    UserAuthenticationStateDto toDto(UserAuthenticationState state);

    default UserId toId(GetNewUserStatusQuery query) {
        return UserId.of(query.userId());
    }

}
