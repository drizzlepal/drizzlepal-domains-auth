package com.drizzlepal.domains.auth.api.dto.response;

import lombok.Data;

@Data
public class LoginResponse {

    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

}
