package com.drizzlepal.domains.auth.infrastructure.controller.dto.response;

import com.drizzlepal.domains.auth.api.dto.response.LoginResponse;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "用户登录响应", description = "用户登录接口响应参数模型，包含访问令牌和刷新令牌")
public class UserLoginResponseDto implements DomainControllerResponse<LoginResponse, UserLoginResponseDto> {

    @Schema(description = "访问令牌")
    private String token;

    @Override
    public UserLoginResponseDto fromApiResponse(LoginResponse response) {
        this.setToken(response.getToken());
        return this;
    }
}
