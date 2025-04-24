package com.review.infrastructure.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "authentication_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthenticationUserEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String password;

}
