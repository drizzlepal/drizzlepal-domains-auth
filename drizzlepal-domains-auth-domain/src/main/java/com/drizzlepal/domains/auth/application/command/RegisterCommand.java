package com.drizzlepal.domains.auth.application.command;

import com.drizzlepal.domains.auth.domain.model.User;

import lombok.Data;

@Data
public class RegisterCommand {

    private String username;

    private String password;

    public User toDomainUser() {
        return User.builder().name(username).password(password).build();
    }

}
