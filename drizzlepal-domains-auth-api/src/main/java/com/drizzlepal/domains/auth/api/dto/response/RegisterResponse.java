package com.drizzlepal.domains.auth.api.dto.response;

import lombok.Data;

@Data
public class RegisterResponse {

    private String userId;

    private String userStatus;

    public RegisterResponse(String userId, String userStatus) {
        this.userId = userId;
        this.userStatus = userStatus;
    }

}
