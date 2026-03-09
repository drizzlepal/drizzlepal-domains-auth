package com.drizzlepal.domains.auth.infrastructure.controller.dto.request;

import java.util.List;

import com.drizzlepal.domains.auth.api.dto.request.UpdateRoleRequest;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "更新角色请求", description = "更新角色请求体")
public class UpdateRoleRequestDto implements DomainControllerRequest<UpdateRoleRequest> {

    @Schema(description = "角色ID", example = "1xxxxx")
    @NotBlank(message = "角色ID不能为空")
    private String id;

    @Schema(description = "角色名称", example = "管理员")
    @Size(max = 64, message = "角色名称长度必须在64以内")
    private String name;

    @Schema(description = "角色描述", example = "系统管理员角色")
    @Size(max = 512, message = "角色描述长度必须在512以内")
    private String description;

    @Schema(description = "权限ID列表")
    private List<String> permissionIds;

    @Override
    public UpdateRoleRequest toApiRequest() {
        return UpdateRoleRequest.builder()
                .id(id)
                .name(name)
                .description(description)
                .permissionIds(permissionIds)
                .build();
    }
}
