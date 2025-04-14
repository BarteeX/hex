package com.review.hex_with_ddd.common.adapter;

import com.review.hex_with_ddd.common.domain.UnitOfWork;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

public class SpringTransactionalUnitOfWork
      implements UnitOfWork {

    @Transactional
    @Override
    public <T> T run(Supplier<T> supplier) {
        return supplier.get();
    }

    @Transactional
    @Override
    public void run(Runnable runnable) {
        runnable.run();
    }

    @Transactional(readOnly = true)
    @Override
    public <T> T readOnly(Supplier<T> supplier) {
        return supplier.get();
    }

    @Transactional(readOnly = true)
    @Override
    public void readOnly(Runnable runnable) {
        runnable.run();
    }

}
