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
public class GetUserPageRequest implements DomainApiRequest {

    private Integer pageNum;

    private Integer pageSize;

    private String keyword;

    private String roleId;

    private String status;
}
