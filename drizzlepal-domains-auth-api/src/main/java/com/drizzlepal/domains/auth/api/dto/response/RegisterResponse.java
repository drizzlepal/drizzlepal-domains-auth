package com.drizzlepal.domains.auth.api.dto.response;

import com.drizzlepal.domains.common.api.dto.DomainApiResponse;

import lombok.Data;

@Data
public class RegisterResponse implements DomainApiResponse {

    private String userId;

    private String userStatus;

    public RegisterResponse(String userId, String userStatus) {
        this.userId = userId;
        this.userStatus = userStatus;
    }
}
