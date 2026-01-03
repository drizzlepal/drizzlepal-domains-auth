package com.drizzlepal.domains.auth.application.command;

import lombok.Data;

@Data
public class LoginCommand {

    private String username;

    private String password;

    public LoginCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
