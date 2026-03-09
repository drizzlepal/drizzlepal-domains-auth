package com.drizzlepal.domains.auth.api.dto.response;

import java.util.List;

import com.drizzlepal.domains.common.api.dto.DomainApiResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetRolePageResponse implements DomainApiResponse {

    private List<GetRoleResponse> records;

    private Long total;

    private Integer pageNum;

    private Integer pageSize;
}
