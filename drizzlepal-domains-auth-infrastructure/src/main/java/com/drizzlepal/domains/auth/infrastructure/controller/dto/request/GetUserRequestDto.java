package com.drizzlepal.domains.auth.infrastructure.controller.dto.request;

import com.drizzlepal.domains.auth.api.dto.request.GetUserRequest;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(name = "获取用户请求", description = "获取用户请求体")
public class GetUserRequestDto implements DomainControllerRequest<GetUserRequest> {

    @Schema(description = "用户ID", example = "user_001")
    @NotBlank(message = "用户ID不能为空")
    private String id;

    @Override
    public GetUserRequest toApiRequest() {
        return GetUserRequest.builder()
                .id(id)
                .build();
    }
}
