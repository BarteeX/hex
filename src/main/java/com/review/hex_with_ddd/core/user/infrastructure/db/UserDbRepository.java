package com.review.hex_with_ddd.core.user.infrastructure.db;

import com.review.hex_with_ddd.core.user.infrastructure.db.entity.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDbRepository
      extends JpaRepository<UserDB, UUID> {

}
