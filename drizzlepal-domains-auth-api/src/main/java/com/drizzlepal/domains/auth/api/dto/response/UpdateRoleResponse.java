package com.drizzlepal.domains.auth.api.dto.response;

import java.util.Date;
import java.util.List;

import com.drizzlepal.domains.common.api.dto.DomainApiResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateRoleResponse implements DomainApiResponse {

    private String id;

    private String name;

    private String description;

    private List<String> permissionIds;

    private Date createTime;

    private Date updateTime;
}
