package com.review.infrastructure.config;

import com.review.adapter.out.AuthenticationPasswordEncoderAdapter;
import com.review.adapter.out.JwtTokenProviderAdapter;
import com.review.adapter.persistance.repository.AuthenticationUserJpaRepositoryAdapter;
import com.review.application.handler.AuthenticationUserCommandHandler;
import com.review.application.mapper.AuthenticationUserMapper;
import com.review.application.mapper.AuthenticationUserMapperImpl;
import com.review.application.usecase.AuthenticateUserUseCase;
import com.review.application.usecase.RegisterAuthenticationUserUseCase;
import com.review.domain.UnitOfWork;
import com.review.domain.port.AuthenticationPasswordEncoder;
import com.review.domain.port.TokenProvider;
import com.review.domain.repository.AuthenticationUserRepository;
import com.review.domain.service.AuthenticationTokenService;
import com.review.domain.service.AuthenticationUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration(proxyBeanMethods = false)
public class AuthenticationConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationUserRepository authenticationUserRepository(
          AuthenticationUserJpaRepositoryAdapter adapter
    ) {
        return adapter;
    }

    @Bean
    public AuthenticationPasswordEncoder authenticationPasswordEncoder(
          AuthenticationPasswordEncoderAdapter adapter
    ) {
        return adapter;
    }

    @Bean
    public AuthenticationUserService authenticationUserService(
          AuthenticationUserRepository authenticationUserRepository,
          AuthenticationPasswordEncoder authenticationPasswordEncoder
    ) {
        return new AuthenticationUserService(
              authenticationUserRepository,
              authenticationPasswordEncoder
        );
    }

    @Bean
    public TokenProvider tokenProvider(
          JwtTokenProviderAdapter adapter
    ) {
        return adapter;
    }

    @Bean
    public AuthenticationTokenService authenticationTokenService(
          TokenProvider tokenProvider
    ) {
        return new AuthenticationTokenService(tokenProvider);
    }

    @Bean
    public AuthenticationUserMapper authenticationUserMapper() {
        return new AuthenticationUserMapperImpl();
    }

    @Bean
    public AuthenticationUserCommandHandler authenticationUserCommandHandler(
          UnitOfWork unitOfWork,
          AuthenticationUserMapper userMapper,
          AuthenticationUserService userService,
          AuthenticationTokenService tokenService
    ) {
        return new AuthenticationUserCommandHandler(
              unitOfWork,
              userMapper,
              userService,
              tokenService
        );
    }

    @Bean
    @Primary
    public AuthenticateUserUseCase authenticateUserUseCase(
          AuthenticationUserCommandHandler handler
    ) {
        return handler;
    }

    @Bean
    @Primary
    public RegisterAuthenticationUserUseCase registerAuthenticationUserUseCase(
          AuthenticationUserCommandHandler handler
    ) {
        return handler;
    }

}
