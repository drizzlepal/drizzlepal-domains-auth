package com.drizzlepal.domains.auth.api.dto.response;

import com.drizzlepal.domains.common.api.dto.DomainApiResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateRoleResponse implements DomainApiResponse {

    private String roleId;
}
