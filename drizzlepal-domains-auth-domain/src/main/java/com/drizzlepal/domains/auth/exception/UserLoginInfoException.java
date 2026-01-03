package com.drizzlepal.domains.auth.exception;

public class UserLoginInfoException extends RuntimeException {

    public UserLoginInfoException() {
        super("Wrong username and password");
    }

}
