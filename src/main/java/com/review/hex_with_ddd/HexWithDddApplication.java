package com.review.hex_with_ddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
@ConfigurationPropertiesScan
@EnableConfigurationProperties
public class HexWithDddApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexWithDddApplication.class, args);
    }

}
