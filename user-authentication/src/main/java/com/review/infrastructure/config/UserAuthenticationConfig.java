package com.review.infrastructure.config;

import com.review.adapter.event.emitter.UserAuthenticationEventEmitterAdapter;
import com.review.adapter.persistance.repository.UserAuthenticationStateRepositoryAdapter;
import com.review.application.handler.UserActionCommandHandler;
import com.review.application.handler.UserActionCommandQueryHandler;
import com.review.application.mapper.UserAuthenticationStateMapper;
import com.review.application.mapper.UserAuthenticationStateMapperImpl;
import com.review.application.usecase.*;
import com.review.domain.UnitOfWork;
import com.review.domain.port.UserAuthenticationEventEmitter;
import com.review.domain.repository.UserAuthenticationStateRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration(proxyBeanMethods = false)
public class UserAuthenticationConfig {

    @Bean
    UserAuthenticationEventEmitter userAuthenticationEventEmitter(
          ApplicationEventPublisher applicationEventPublisher
    ) {
        return new UserAuthenticationEventEmitterAdapter(applicationEventPublisher);
    }

    @Bean
    UserAuthenticationStateRepository userAuthenticationStateRepository(
          UserAuthenticationStateRepositoryAdapter userAuthenticationStateHashRepository
    ) {
        return userAuthenticationStateHashRepository;
    }

    @Bean
    UserAuthenticationStateMapper userAuthenticationStateMapper() {
        return new UserAuthenticationStateMapperImpl();
    }

    @Bean
    UserActionCommandHandler userActionCommandHandler(
          UserAuthenticationEventEmitter userAuthenticationEventEmitter,
          UserAuthenticationStateRepository userAuthenticationStateRepository,
          UnitOfWork unitOfWork
    ) {
        return new UserActionCommandHandler(
              userAuthenticationEventEmitter,
              userAuthenticationStateRepository,
              unitOfWork
        );
    }

    @Bean
    UserActionCommandQueryHandler userActionCommandQueryHandler(
          UserAuthenticationStateRepository userAuthenticationStateRepository,
          UserAuthenticationStateMapper userAuthenticationStateMapper
    ) {
        return new UserActionCommandQueryHandler(
              userAuthenticationStateRepository,
              userAuthenticationStateMapper
        );
    }

    @Bean
    @Primary
    CreateNewUserActionUseCase createNewUserActionUseCase(
          UserActionCommandHandler userActionCommandHandler
    ) {
        return userActionCommandHandler;
    }

    @Bean
    @Primary
    NewAuthenticateUserCreatedUseCase newAuthenticateUserCreatedUseCase(
          UserActionCommandHandler userActionCommandHandler
    ) {
        return userActionCommandHandler;
    }

    @Bean
    @Primary
    NewAuthenticateUserCreatedFailureUseCase newAuthenticateUserCreatedFailureUseCase(
          UserActionCommandHandler userActionCommandHandler
    ) {
        return userActionCommandHandler;
    }

    @Bean
    @Primary
    NewUserCreatedUseCase newUserCreatedUseCase(
          UserActionCommandHandler userActionCommandHandler
    ) {
        return userActionCommandHandler;
    }

    @Bean
    @Primary
    NewUserCreatedFailureUseCase newUserCreatedFailureUseCase(
          UserActionCommandHandler userActionCommandHandler
    ) {
        return userActionCommandHandler;
    }

    @Bean
    @Primary
    GetNewUserStatusUseCase getNewUserStatusUseCase(
          UserActionCommandQueryHandler userActionCommandQueryHandler
    ) {
        return userActionCommandQueryHandler;
    }

}
