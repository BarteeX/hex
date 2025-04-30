package com.review.infrastructure.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserAuthenticationStateHashRepository
      extends CrudRepository<UserAuthenticationStateHash, UUID> {

}
