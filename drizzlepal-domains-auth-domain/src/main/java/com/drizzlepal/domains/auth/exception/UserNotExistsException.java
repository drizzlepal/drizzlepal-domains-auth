package com.drizzlepal.domains.auth.exception;

public class UserNotExistsException extends RuntimeException {

    public UserNotExistsException(String userName) {
        super("User " + userName + " not exists");
    }

}
