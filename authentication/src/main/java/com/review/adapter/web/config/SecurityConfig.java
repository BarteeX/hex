package com.review.adapter.web.config;

import com.review.infrastructure.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
          throws Exception {
        return http
              .csrf(AbstractHttpConfigurer::disable)
              .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
              .authorizeHttpRequests(this::getRequestMatcherRegistry)
              .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
              .build();
    }

    private void getRequestMatcherRegistry(
          AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry auth
    ) {
        auth.requestMatchers(
                    "/authentication/**",
                    "/actuator/**",
                    "/actuator",
                    "/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui",
                    "/swagger-ui.html",
                    "/webjars/**"
              )
              .permitAll()
              .requestMatchers("/user")
              .permitAll()
              .anyRequest()
              .authenticated();
    }

}