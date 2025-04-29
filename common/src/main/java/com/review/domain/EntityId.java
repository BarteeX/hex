package com.review.domain;

public abstract class EntityId<T>
      extends ValueObject<T> {

    protected EntityId(T value) {
        super(value);
    }

}
