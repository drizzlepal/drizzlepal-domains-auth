package com.drizzlepal.domains.auth.infrastructure.service;

import org.springframework.stereotype.Service;

import com.drizzlepal.domains.auth.domain.repository.UserRepository;
import com.drizzlepal.domains.auth.domain.service.UserDomainService;

@Service
public class UserDomainServiceImpl extends UserDomainService {

    public UserDomainServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }

}
