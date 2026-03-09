package com.drizzlepal.domains.auth.infrastructure.controller.dto.response;

import java.util.Date;
import java.util.List;

import com.drizzlepal.domains.auth.api.dto.response.GetRoleResponse;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "获取角色响应", description = "获取角色响应参数模型")
public class GetRoleResponseDto implements DomainControllerResponse<GetRoleResponse, GetRoleResponseDto> {

    @Schema(description = "角色ID")
    private String id;

    @Schema(description = "角色名称")
    private String name;

    @Schema(description = "角色描述")
    private String description;

    @Schema(description = "权限ID列表")
    private List<String> permissionIds;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "更新时间")
    private Date updateTime;

    @Override
    public GetRoleResponseDto fromApiResponse(GetRoleResponse apiResponse) {
        this.id = apiResponse.getId();
        this.name = apiResponse.getName();
        this.description = apiResponse.getDescription();
        this.permissionIds = apiResponse.getPermissionIds();
        this.createTime = apiResponse.getCreateTime();
        this.updateTime = apiResponse.getUpdateTime();
        return this;
    }
}
