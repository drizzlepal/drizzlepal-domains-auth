package com.drizzlepal.domains.auth.exception;

public class UserNameAlreadyExistsException extends RuntimeException {

    public UserNameAlreadyExistsException(String username) {
        super("User name " + username + " already exists");
    }

}
