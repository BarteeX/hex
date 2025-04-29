package com.review.domain;

import lombok.*;

@Getter
@ToString
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(
      access = AccessLevel.PROTECTED,
      force = true
)
public abstract class ValueObject<T> {

    protected final T value;

}
