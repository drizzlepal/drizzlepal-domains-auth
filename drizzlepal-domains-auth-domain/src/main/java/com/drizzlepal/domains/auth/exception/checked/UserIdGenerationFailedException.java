package com.drizzlepal.domains.auth.exception.checked;

public class UserIdGenerationFailedException extends Exception {

    public UserIdGenerationFailedException(int retryCount) {
        super("User Id Generation Fail, retry count: " + retryCount);
    }

    public UserIdGenerationFailedException(Exception e) {
        super("User Id Generation Fail", e);
    }

}
