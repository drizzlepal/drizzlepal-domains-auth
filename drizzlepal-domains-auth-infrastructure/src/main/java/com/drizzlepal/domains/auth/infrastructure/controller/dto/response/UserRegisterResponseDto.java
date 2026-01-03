package com.drizzlepal.domains.auth.infrastructure.controller.dto.response;

import com.drizzlepal.domains.auth.api.dto.response.RegisterResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(name = "用户注册响应", description = "用户注册响应；用户注册成功返回用户ID")
public class UserRegisterResponseDto {

    @Schema(description = "用户ID")
    private String id;

    @Schema(description = "用户状态")
    private String userStatus;

    public static UserRegisterResponseDto fromDomain(RegisterResponse user) {
        return new UserRegisterResponseDto(user.getUserId(), user.getUserStatus());
    }

}
