package com.drizzlepal.domains.auth.api.dto.request;

import com.drizzlepal.domains.common.api.dto.DomainApiRequest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetRolePageRequest implements DomainApiRequest {

    private Integer pageNum;

    private Integer pageSize;

    private String keyword;
}
