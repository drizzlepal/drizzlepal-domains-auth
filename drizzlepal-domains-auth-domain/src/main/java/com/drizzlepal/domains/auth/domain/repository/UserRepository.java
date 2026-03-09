package com.drizzlepal.domains.auth.domain.repository;

import java.util.List;
import java.util.Optional;

import com.drizzlepal.domains.auth.domain.model.User;

public interface UserRepository {

    Optional<User> findById(String id);

    Optional<User> findUserNotDeletedByUsername(String username);

    List<User> findAll();

    void create(User user);

    void update(User user);

    void delete(String id);

    boolean existsByNameForRegister(String username);

    boolean existsByNameForUpdate(String userId, String username);
}
