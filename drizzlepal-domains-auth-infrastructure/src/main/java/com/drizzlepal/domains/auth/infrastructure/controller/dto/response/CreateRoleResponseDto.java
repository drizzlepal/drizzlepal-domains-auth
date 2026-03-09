package com.drizzlepal.domains.auth.infrastructure.controller.dto.response;

import com.drizzlepal.domains.auth.api.dto.response.CreateRoleResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "创建角色响应", description = "创建角色响应体")
public class CreateRoleResponseDto {

    @Schema(description = "角色ID")
    private String roleId;

    public static CreateRoleResponseDto fromDomain(CreateRoleResponse response) {
        CreateRoleResponseDto dto = new CreateRoleResponseDto();
        dto.setRoleId(response.getRoleId());
        return dto;
    }
}
