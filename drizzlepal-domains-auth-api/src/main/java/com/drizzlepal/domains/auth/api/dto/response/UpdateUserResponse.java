package com.drizzlepal.domains.auth.api.dto.response;

import java.util.Date;

import com.drizzlepal.domains.common.api.dto.DomainApiResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUserResponse implements DomainApiResponse {

    private String id;

    private String username;

    private String email;

    private String roleId;

    private String status;

    private Date createTime;

    private Date updateTime;
}
