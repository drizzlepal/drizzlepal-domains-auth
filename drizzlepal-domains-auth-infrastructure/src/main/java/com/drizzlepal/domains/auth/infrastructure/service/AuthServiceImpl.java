package com.drizzlepal.domains.auth.infrastructure.service;

import org.springframework.stereotype.Service;

import com.drizzlepal.domains.auth.api.AuthApi;
import com.drizzlepal.domains.auth.api.dto.request.LoginRequest;
import com.drizzlepal.domains.auth.api.dto.request.RegisterRequest;
import com.drizzlepal.domains.auth.api.dto.response.LoginResponse;
import com.drizzlepal.domains.auth.api.dto.response.RegisterResponse;
import com.drizzlepal.domains.auth.application.AuthApplication;
import com.drizzlepal.domains.auth.application.command.LoginCommand;
import com.drizzlepal.domains.auth.application.command.RegisterCommand;
import com.drizzlepal.domains.auth.application.result.LoginResult;
import com.drizzlepal.domains.auth.application.result.RegisterResult;
import com.drizzlepal.domains.auth.domain.port.PasswordEncoder;
import com.drizzlepal.domains.auth.domain.repository.UserRepository;
import com.drizzlepal.domains.auth.domain.service.UserDomainService;

@Service
public class AuthServiceImpl implements AuthApi {

    private final AuthApplication authApplication;

    public AuthServiceImpl(UserRepository userRepository, UserDomainService userDomainService,
            PasswordEncoder passwordEncoder) {
        this.authApplication = new AuthApplication(userRepository, userDomainService, passwordEncoder);
    }

    @Override
    public LoginResponse login(LoginRequest LoginRequest) {
        LoginResult login = authApplication.login(new LoginCommand(null, null));
        return new LoginResponse(login.getToken());
    }

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        RegisterResult register = authApplication.register(new RegisterCommand());
        return new RegisterResponse(register.getUserId(), register.getUserStatus().name());
    }

}
