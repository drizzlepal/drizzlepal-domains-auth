package com.drizzlepal.domains.auth.domain.service;

import com.drizzlepal.domains.auth.domain.repository.UserRepository;
import com.drizzlepal.domains.auth.exception.UserNameAlreadyExistsException;

public class UserDomainService {

    private final UserRepository userRepository;

    public UserDomainService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void ensureRegisterUserNameUnique(String username) {
        if (userRepository.existsByNameForRegister(username)) {
            throw new UserNameAlreadyExistsException(username);
        }
    }

}
