package com.drizzlepal.domains.auth.infrastructure.controller.dto.response;

import com.drizzlepal.domains.auth.api.dto.response.LoginResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(name = "用户登录响应", description = "用户登录接口响应参数模型，包含访问令牌和刷新令牌")
public class UserLoginResponseDto {

    @Schema(description = "访问令牌")
    private String token;

    public static UserLoginResponseDto fromDomain(LoginResponse loginResponse) {
        return new UserLoginResponseDto(loginResponse.getToken());
    }

}
