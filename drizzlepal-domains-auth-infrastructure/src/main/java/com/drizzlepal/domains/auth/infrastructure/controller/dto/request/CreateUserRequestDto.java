package com.drizzlepal.domains.auth.infrastructure.controller.dto.request;

import com.drizzlepal.domains.auth.api.dto.request.CreateUserRequest;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "创建用户请求", description = "创建用户请求体")
public class CreateUserRequestDto implements DomainControllerRequest<CreateUserRequest> {

    @Schema(description = "用户名", example = "admin")
    @NotBlank(message = "用户名不能为空")
    @Size(max = 64, message = "用户名长度必须在64以内")
    private String username;

    @Schema(description = "邮箱", example = "admin@example.com")
    @Email(message = "邮箱格式不正确")
    private String email;

    @Schema(description = "密码", example = "123456")
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度必须在6到20之间")
    private String password;

    @Schema(description = "角色ID", example = "role_001")
    private String roleId;

    @Schema(description = "状态", example = "ACTIVE")
    private String status;

    @Override
    public CreateUserRequest toApiRequest() {
        return CreateUserRequest.builder()
                .username(username)
                .email(email)
                .password(password)
                .roleId(roleId)
                .status(status)
                .build();
    }
}
