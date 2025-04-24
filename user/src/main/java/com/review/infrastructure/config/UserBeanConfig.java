package com.review.infrastructure.config;

import com.review.adapter.out.mapper.UserDBMapper;
import com.review.adapter.out.repository.UserRepositoryAdapter;
import com.review.application.handler.UserCommandHandler;
import com.review.application.handler.UserQueryHandler;
import com.review.application.mapper.UserMapper;
import com.review.application.mapper.UserMapperImpl;
import com.review.application.usecase.AddUserUseCase;
import com.review.application.usecase.DeleteUserUseCase;
import com.review.application.usecase.GetUserUseCase;
import com.review.domain.UnitOfWork;
import com.review.domain.port.UserRepository;
import com.review.domain.service.UserService;
import com.review.infrastructure.db.UserDbRepository;
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
