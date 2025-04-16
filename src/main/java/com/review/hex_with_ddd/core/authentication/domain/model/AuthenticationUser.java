package com.review.hex_with_ddd.core.authentication.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthenticationUser {

    private AuthenticationUserId id;

    private String password;

}
