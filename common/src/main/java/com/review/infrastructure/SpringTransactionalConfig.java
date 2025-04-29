package com.review.infrastructure;

import com.review.adapter.SpringTransactionalUnitOfWork;
import com.review.application.ValueObjectMapper;
import com.review.domain.UnitOfWork;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringTransactionalConfig {

    @Bean
    public UnitOfWork unitOfWork() {
        return new SpringTransactionalUnitOfWork();
    }

    @Bean
    ValueObjectMapper valueObjectMapper() {
        return new ValueObjectMapper();
    }

}
