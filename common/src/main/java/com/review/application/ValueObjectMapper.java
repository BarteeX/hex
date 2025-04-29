package com.review.application;

import com.review.domain.*;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper
public class ValueObjectMapper {

    public <T> T toValue(ValueObject<T> valueObject) {
        return valueObject == null ? null : valueObject.getValue();
    }

    public UserId toUserId(UUID id) {
        return UserId.of(id);
    }

    public FirstName toFirstName(String value) {
        return FirstName.of(value);
    }

    public LastName toLastName(String value) {
        return LastName.of(value);
    }

    public Username toUsername(String value) {
        return Username.of(value);
    }

    public Password toPassword(String value) {
        return Password.of(value);
    }

}
