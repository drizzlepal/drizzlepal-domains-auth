package com.drizzlepal.domains.auth.infrastructure.controller.dto.request;

import com.drizzlepal.domains.auth.api.dto.request.DeleteRoleRequest;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(name = "删除角色请求", description = "删除角色请求体")
public class DeleteRoleRequestDto implements DomainControllerRequest<DeleteRoleRequest> {

    @Schema(description = "角色ID", example = "1xxxxx")
    @NotBlank(message = "角色ID不能为空")
    private String id;

    @Override
    public DeleteRoleRequest toApiRequest() {
        return DeleteRoleRequest.builder()
                .id(id)
                .build();
    }
}
