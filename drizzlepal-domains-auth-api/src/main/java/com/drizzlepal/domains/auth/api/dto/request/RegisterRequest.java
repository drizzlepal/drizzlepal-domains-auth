package com.drizzlepal.domains.auth.api.dto.request;

import com.drizzlepal.domains.common.api.dto.DomainApiRequest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest implements DomainApiRequest {

    private String username;
    private String password;
}
