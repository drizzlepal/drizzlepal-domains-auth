package com.drizzlepal.domains.auth.infrastructure.controller.dto.request;

import com.drizzlepal.domains.auth.api.dto.request.GetUserPageRequest;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Schema(name = "分页查询用户请求", description = "分页查询用户请求体")
public class GetUserPageRequestDto implements DomainControllerRequest<GetUserPageRequest> {

    @Schema(description = "页码", example = "1")
    @Min(value = 1, message = "页码必须大于0")
    private Integer pageNum = 1;

    @Schema(description = "每页数量", example = "10")
    @Min(value = 1, message = "每页数量必须大于0")
    @Max(value = 100, message = "每页数量不能超过100")
    private Integer pageSize = 10;

    @Schema(description = "关键字", example = "admin")
    private String keyword;

    @Schema(description = "角色ID", example = "role_001")
    private String roleId;

    @Schema(description = "状态", example = "ACTIVE")
    private String status;

    @Override
    public GetUserPageRequest toApiRequest() {
        return GetUserPageRequest.builder()
                .pageNum(pageNum)
                .pageSize(pageSize)
                .keyword(keyword)
                .roleId(roleId)
                .status(status)
                .build();
    }
}
