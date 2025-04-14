package com.review.hex_with_ddd.common.infrastructure;

import com.review.hex_with_ddd.common.adapter.SpringTransactionalUnitOfWork;
import com.review.hex_with_ddd.common.domain.UnitOfWork;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringTransactionalConfig {

    @Bean
    public UnitOfWork unitOfWork() {
        return new SpringTransactionalUnitOfWork();
    }

}
