package com.drizzlepal.domains.auth.application;

import com.drizzlepal.domains.auth.application.command.LoginCommand;
import com.drizzlepal.domains.auth.application.command.RegisterCommand;
import com.drizzlepal.domains.auth.application.result.LoginResult;
import com.drizzlepal.domains.auth.application.result.RegisterResult;
import com.drizzlepal.domains.auth.domain.model.User;
import com.drizzlepal.domains.auth.domain.port.PasswordEncoder;
import com.drizzlepal.domains.auth.domain.repository.UserRepository;
import com.drizzlepal.domains.auth.domain.service.UserDomainService;
import com.drizzlepal.domains.auth.exception.UserLoginInfoException;
import com.drizzlepal.domains.auth.exception.UserNotExistsException;

public class AuthApplication {

    private final UserRepository userRepository;

    private final UserDomainService userDomainService;

    private final PasswordEncoder passwordEncoder;

    public AuthApplication(UserRepository userRepository, UserDomainService userDomainService,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userDomainService = userDomainService;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResult login(LoginCommand loginCommand) {
        User user = userRepository.findUserNotDeletedByUsername(loginCommand.getUsername())
                .orElseThrow(() -> new UserNotExistsException(loginCommand.getUsername()));
        if (!user.verifyPassword(loginCommand.getPassword(), this.passwordEncoder)) {
            throw new UserLoginInfoException();
        }
        return LoginResult.builder().build();
    }

    public RegisterResult register(RegisterCommand registerCommand) {
        userDomainService.ensureRegisterUserNameUnique(registerCommand.getUsername());
        User user = registerCommand.toDomainUser();
        userRepository.create(user);
        return RegisterResult.builder().build();
    }
}
