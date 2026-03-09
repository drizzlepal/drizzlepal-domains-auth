package com.drizzlepal.domains.auth.infrastructure.controller.dto.request;

import com.drizzlepal.domains.auth.api.dto.request.GetUserByUsernameRequest;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(name = "根据用户名获取用户请求", description = "根据用户名获取用户请求体")
public class GetUserByUsernameRequestDto implements DomainControllerRequest<GetUserByUsernameRequest> {

    @Schema(description = "用户名", example = "admin")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Override
    public GetUserByUsernameRequest toApiRequest() {
        return GetUserByUsernameRequest.builder()
                .username(username)
                .build();
    }
}
