package com.review.infrastructure.db;

import com.review.infrastructure.db.entity.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserDbRepository
      extends JpaRepository<UserDB, UUID> {

    Optional<UserDB> findByUsername(String username);

}
