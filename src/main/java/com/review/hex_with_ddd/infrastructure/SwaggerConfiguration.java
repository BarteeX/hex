package com.review.hex_with_ddd.infrastructure;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition(
      info = @Info(
            title = "Hexagonal Architecture with DDD",
            version = "1.0",
            description = "Hexagonal Architecture with DDD"
      )
)
@Configuration
public class SwaggerConfiguration {

}
