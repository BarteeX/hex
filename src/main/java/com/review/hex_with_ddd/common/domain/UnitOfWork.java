package com.review.hex_with_ddd.common.domain;

import java.util.function.Supplier;

public interface UnitOfWork {

    <T> T run(Supplier<T> supplier);

    void run(Runnable runnable);

    <T> T readOnly(Supplier<T> supplier);

    void readOnly(Runnable runnable);

}
