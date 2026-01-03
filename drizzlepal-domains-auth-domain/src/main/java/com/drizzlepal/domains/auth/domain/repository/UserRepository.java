package com.drizzlepal.domains.auth.domain.repository;

import java.util.Optional;

import com.drizzlepal.domains.auth.domain.model.User;
import com.drizzlepal.domains.auth.exception.checked.UserIdGenerationFailedException;

public interface UserRepository {

    Optional<User> findUserNotDeletedByUsername(String username);

    void create(User user) throws UserIdGenerationFailedException;

    boolean existsByNameForRegister(String username);

    boolean existsByNameForUpdate(String userId, String username);

}
