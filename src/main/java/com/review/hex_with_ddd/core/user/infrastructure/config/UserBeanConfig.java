package com.review.hex_with_ddd.core.user.infrastructure.config;

import com.review.hex_with_ddd.common.domain.UnitOfWork;
import com.review.hex_with_ddd.core.user.adapter.out.mapper.UserDBMapper;
import com.review.hex_with_ddd.core.user.adapter.out.repository.UserRepositoryAdapter;
import com.review.hex_with_ddd.core.user.application.handler.UserCommandHandler;
import com.review.hex_with_ddd.core.user.application.handler.UserQueryHandler;
import com.review.hex_with_ddd.core.user.application.mapper.UserMapper;
import com.review.hex_with_ddd.core.user.application.mapper.UserMapperImpl;
import com.review.hex_with_ddd.core.user.application.usecase.AddUserUseCase;
import com.review.hex_with_ddd.core.user.application.usecase.DeleteUserUseCase;
import com.review.hex_with_ddd.core.user.application.usecase.GetUserUseCase;
import com.review.hex_with_ddd.core.user.domain.port.UserRepository;
import com.review.hex_with_ddd.core.user.domain.service.UserService;
import com.review.hex_with_ddd.core.user.infrastructure.adapter.UserDbRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class UserBeanConfig {

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public UserRepository userRepository(
          UserDBMapper userDBMapper,
          UserDbRepository userRepository
    ) {
        return new UserRepositoryAdapter(
              userDBMapper,
              userRepository
        );
    }

    @Bean
    public UserService userService(
          UserRepository userRepository
    ) {
        return new UserService(userRepository);
    }

    @Bean
    public UserCommandHandler userCommandHandler(
          UserMapper userMapper,
          UserService userService,
          UnitOfWork unitOfWork
    ) {
        return new UserCommandHandler(
              userMapper,
              userService,
              unitOfWork
        );
    }

    @Bean
    @Primary
    public AddUserUseCase addUserUseCase(UserCommandHandler handler) {
        return handler;
    }

    @Bean
    @Primary
    public DeleteUserUseCase deleteUserUseCase(UserCommandHandler handler) {
        return handler;
    }

    @Bean
    public UserQueryHandler userQueryHandler(
          UserMapper userMapper,
          UserService userService,
          UnitOfWork unitOfWork
    ) {
        return new UserQueryHandler(
              userMapper,
              userService,
              unitOfWork
        );
    }

    @Bean
    @Primary
    public GetUserUseCase getUserUseCase(UserQueryHandler handler) {
        return handler;
    }

}
