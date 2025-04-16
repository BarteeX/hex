package com.review.hex_with_ddd.core.user.infrastructure.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "the_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDB {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;

    private String firstName;

    private String lastName;

}
