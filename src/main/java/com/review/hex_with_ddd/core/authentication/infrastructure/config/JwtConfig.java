package com.review.hex_with_ddd.core.authentication.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public record JwtConfig(
      String secret
) {

}
