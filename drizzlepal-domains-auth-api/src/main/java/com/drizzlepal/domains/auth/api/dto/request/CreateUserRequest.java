package com.drizzlepal.domains.auth.api.dto.request;

import com.drizzlepal.domains.common.api.dto.DomainApiRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest implements DomainApiRequest {

    private String username;

    private String email;

    private String password;

    private String roleId;

    private String status;
}
