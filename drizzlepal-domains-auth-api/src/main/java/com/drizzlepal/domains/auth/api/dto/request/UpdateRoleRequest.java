package com.drizzlepal.domains.auth.api.dto.request;

import java.util.List;

import com.drizzlepal.domains.common.api.dto.DomainApiRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleRequest implements DomainApiRequest {

    private String id;

    private String name;

    private String description;

    private List<String> permissionIds;
}
