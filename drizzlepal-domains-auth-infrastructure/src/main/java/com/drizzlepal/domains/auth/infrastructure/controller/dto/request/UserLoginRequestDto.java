package com.drizzlepal.domains.auth.infrastructure.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "用户登录请求", description = "用户登录接口请求参数模型，包含用户名和密码")
public class UserLoginRequestDto {

    @Schema(description = "用户名，不能为空", example = "admin")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Schema(description = "用户密码，长度 6 到 20 位", example = "123456")
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度必须在 6 到 20 之间")
    private String password;

}