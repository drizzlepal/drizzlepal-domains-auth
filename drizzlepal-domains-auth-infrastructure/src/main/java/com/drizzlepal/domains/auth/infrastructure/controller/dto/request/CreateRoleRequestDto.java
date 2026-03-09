package com.drizzlepal.domains.auth.infrastructure.controller.dto.request;

import java.util.List;

import com.drizzlepal.domains.auth.api.dto.request.CreateRoleRequest;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "创建角色请求", description = "创建角色请求体")
public class CreateRoleRequestDto implements DomainControllerRequest<CreateRoleRequest> {

    @Schema(description = "角色名称", example = "管理员")
    @NotBlank(message = "角色名称不能为空")
    @Size(max = 64, message = "角色名称长度必须在64以内")
    private String name;

    @Schema(description = "角色描述", example = "系统管理员角色")
    @Size(max = 512, message = "角色描述长度必须在512以内")
    private String description;

    @Schema(description = "权限ID列表")
    private List<String> permissionIds;

    @Override
    public CreateRoleRequest toApiRequest() {
        return CreateRoleRequest.builder()
                .name(name)
                .description(description)
                .permissionIds(permissionIds)
                .build();
    }
}
