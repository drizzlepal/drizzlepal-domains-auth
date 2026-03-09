package com.drizzlepal.domains.auth.infrastructure.controller.dto.request;

import com.drizzlepal.domains.auth.api.dto.request.GetRoleRequest;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(name = "获取角色请求", description = "获取角色请求体")
public class GetRoleRequestDto implements DomainControllerRequest<GetRoleRequest> {

    @Schema(description = "角色ID", example = "1xxxxx")
    @NotBlank(message = "角色ID不能为空")
    private String id;

    @Override
    public GetRoleRequest toApiRequest() {
        return GetRoleRequest.builder()
                .id(id)
                .build();
    }
}
