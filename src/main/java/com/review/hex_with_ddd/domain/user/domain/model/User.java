package com.review.hex_with_ddd.domain.user.domain.model;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private UUID id;

    private String username;

    private String firstName;

    private String lastName;

    public String getIdAsString() {
        return id.toString();
    }

}
