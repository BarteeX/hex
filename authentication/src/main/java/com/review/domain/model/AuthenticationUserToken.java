package com.review.domain.model;

import com.review.domain.Token;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AuthenticationUserToken {

    private Token token;

}
