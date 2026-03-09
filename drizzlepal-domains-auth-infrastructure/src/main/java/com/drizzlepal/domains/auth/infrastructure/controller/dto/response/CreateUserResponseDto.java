package com.drizzlepal.domains.auth.infrastructure.controller.dto.response;

import com.drizzlepal.domains.auth.api.dto.response.CreateUserResponse;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "创建用户响应", description = "创建用户响应体")
public class CreateUserResponseDto implements DomainControllerResponse<CreateUserResponse, CreateUserResponseDto> {

    @Schema(description = "用户ID")
    private String userId;

    @Override
    public CreateUserResponseDto fromApiResponse(CreateUserResponse response) {
        this.setUserId(response.getUserId());
        return this;
    }
}
