package com.review.application.handler;

import com.review.application.dto.UserAuthenticationStateDto;
import com.review.application.exception.NewUserStatusNotExistsException;
import com.review.application.mapper.UserAuthenticationStateMapper;
import com.review.application.query.GetNewUserStatusQuery;
import com.review.application.usecase.GetNewUserStatusUseCase;
import com.review.domain.UserId;
import com.review.domain.model.UserAuthenticationState;
import com.review.domain.repository.UserAuthenticationStateRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserActionCommandQueryHandler
      implements GetNewUserStatusUseCase {

    private final UserAuthenticationStateRepository stateRepository;

    private final UserAuthenticationStateMapper stateMapper;

    @Override
    public UserAuthenticationStateDto execute(GetNewUserStatusQuery query) {
        UserId userId = stateMapper.toId(query);
        Optional<UserAuthenticationState> byUserId = stateRepository.findByUserId(userId);

        return byUserId.map(stateMapper::toDto)
              .orElseThrow(() -> NewUserStatusNotExistsException.of(userId));
    }

}
