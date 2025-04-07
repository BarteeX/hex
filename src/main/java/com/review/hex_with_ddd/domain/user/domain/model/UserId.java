package com.review.hex_with_ddd.domain.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserId {

    private UUID id;

    public String getIdAsString() {
        return id.toString();
    }

}
