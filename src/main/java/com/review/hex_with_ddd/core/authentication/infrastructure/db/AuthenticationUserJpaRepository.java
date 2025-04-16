package com.review.hex_with_ddd.core.authentication.infrastructure.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthenticationUserJpaRepository
      extends JpaRepository<AuthenticationUserEntity, UUID> {

}
