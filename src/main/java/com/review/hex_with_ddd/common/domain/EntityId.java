package com.review.hex_with_ddd.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class EntityId<T> {

    private T id;

}
