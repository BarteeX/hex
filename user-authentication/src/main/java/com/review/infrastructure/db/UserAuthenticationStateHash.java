package com.review.infrastructure.db;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@RedisHash("user-authentication-state")
public class UserAuthenticationStateHash {

    @Id
    private UUID userId;

    private Set<String> status;

    private String kind;

    private String errorMessage;

}
