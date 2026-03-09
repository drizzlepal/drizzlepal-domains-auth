package com.drizzlepal.domains.auth.domain.repository;

import java.util.List;
import java.util.Optional;

import com.drizzlepal.domains.auth.domain.model.Role;

public interface RoleRepository {

    Optional<Role> findById(String id);

    List<Role> findAll();

    void create(Role role);

    void update(Role role);

    void delete(String id);
}
