package com.drizzlepal.domains.auth.exception;

public class RetryFailedException extends RuntimeException {

    public RetryFailedException(String message) {
        super(message);
    }

}
