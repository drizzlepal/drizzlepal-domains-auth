package com.drizzlepal.domains.auth.infrastructure.controller.dto.response;

import java.util.Date;

import com.drizzlepal.domains.auth.api.dto.response.UpdateUserResponse;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "更新用户响应", description = "更新用户响应体")
public class UpdateUserResponseDto implements DomainControllerResponse<UpdateUserResponse, UpdateUserResponseDto> {

    @Schema(description = "用户ID")
    private String id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "角色ID")
    private String roleId;

    @Schema(description = "状态")
    private String status;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "更新时间")
    private Date updateTime;

    @Override
    public UpdateUserResponseDto fromApiResponse(UpdateUserResponse response) {
        this.setId(response.getId());
        this.setUsername(response.getUsername());
        this.setEmail(response.getEmail());
        this.setRoleId(response.getRoleId());
        this.setStatus(response.getStatus());
        this.setCreateTime(response.getCreateTime());
        this.setUpdateTime(response.getUpdateTime());
        return this;
    }
}
