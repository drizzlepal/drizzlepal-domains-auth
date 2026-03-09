package com.drizzlepal.domains.auth.api.dto.response;

import com.drizzlepal.domains.common.api.dto.DomainApiResponse;

import lombok.Data;

@Data
public class LoginResponse implements DomainApiResponse {

    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }
}
