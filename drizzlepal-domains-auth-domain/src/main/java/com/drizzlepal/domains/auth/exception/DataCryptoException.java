package com.drizzlepal.domains.auth.exception;

public class DataCryptoException extends RuntimeException {

    public DataCryptoException(String message, Exception e) {
        super(message, e);
    }

}
