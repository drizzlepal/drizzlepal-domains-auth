package com.drizzlepal.domains.auth.infrastructure.controller.dto.response;

import com.drizzlepal.domains.auth.api.dto.response.RegisterResponse;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "用户注册响应", description = "用户注册响应；用户注册成功返回用户ID")
public class UserRegisterResponseDto implements DomainControllerResponse<RegisterResponse, UserRegisterResponseDto> {

    @Schema(description = "用户ID")
    private String id;

    @Schema(description = "用户状态")
    private String userStatus;

    @Override
    public UserRegisterResponseDto fromApiResponse(RegisterResponse response) {
        this.setId(response.getUserId());
        this.setUserStatus(response.getUserStatus());
        return this;
    }
}
