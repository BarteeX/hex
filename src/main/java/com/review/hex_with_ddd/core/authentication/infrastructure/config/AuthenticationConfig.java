package com.review.hex_with_ddd.core.authentication.infrastructure.config;

import com.review.hex_with_ddd.common.domain.UnitOfWork;
import com.review.hex_with_ddd.core.authentication.adapter.out.AuthenticationPasswordEncoderAdapter;
import com.review.hex_with_ddd.core.authentication.adapter.out.JwtTokenProviderAdapter;
import com.review.hex_with_ddd.core.authentication.adapter.persistance.repository.AuthenticationUserJpaRepositoryAdapter;
import com.review.hex_with_ddd.core.authentication.application.handler.AuthenticationUserCommandHandler;
import com.review.hex_with_ddd.core.authentication.application.mapper.AuthenticationUserMapper;
import com.review.hex_with_ddd.core.authentication.application.mapper.AuthenticationUserMapperImpl;
import com.review.hex_with_ddd.core.authentication.application.usecase.AuthenticateUserUseCase;
import com.review.hex_with_ddd.core.authentication.application.usecase.RegisterAuthenticationUserUseCase;
import com.review.hex_with_ddd.core.authentication.domain.port.AuthenticationPasswordEncoder;
import com.review.hex_with_ddd.core.authentication.domain.port.TokenProvider;
import com.review.hex_with_ddd.core.authentication.domain.repository.AuthenticationUserRepository;
import com.review.hex_with_ddd.core.authentication.domain.service.AuthenticationTokenService;
import com.review.hex_with_ddd.core.authentication.domain.service.AuthenticationUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
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
