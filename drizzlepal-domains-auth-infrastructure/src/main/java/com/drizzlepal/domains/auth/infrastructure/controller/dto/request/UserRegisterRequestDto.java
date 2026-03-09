package com.drizzlepal.domains.auth.infrastructure.controller.dto.request;

import com.drizzlepal.domains.auth.api.dto.request.RegisterRequest;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "用户注册请求", description = "用户注册接口请求参数模型，包含用户名和密码")
public class UserRegisterRequestDto implements DomainControllerRequest<RegisterRequest> {

    @Schema(description = "用户名，不能为空", example = "admin")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Schema(description = "密码,不能为空", example = "123456")
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度必须在6到20之间")
    private String password;

    @Override
    public RegisterRequest toApiRequest() {
        return RegisterRequest.builder()
                .build();
    }
}
