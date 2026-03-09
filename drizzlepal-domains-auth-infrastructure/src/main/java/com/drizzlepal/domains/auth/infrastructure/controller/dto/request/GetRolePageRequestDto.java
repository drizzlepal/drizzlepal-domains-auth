package com.drizzlepal.domains.auth.infrastructure.controller.dto.request;

import com.drizzlepal.domains.auth.api.dto.request.GetRolePageRequest;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "分页查询角色请求", description = "分页查询角色请求体")
public class GetRolePageRequestDto implements DomainControllerRequest<GetRolePageRequest> {

    @Schema(description = "页码", example = "1")
    private Integer pageNum;

    @Schema(description = "每页数量", example = "10")
    private Integer pageSize;

    @Schema(description = "关键字(角色名/描述)", example = "管理员")
    private String keyword;

    @Override
    public GetRolePageRequest toApiRequest() {
        return GetRolePageRequest.builder()
                .pageNum(pageNum)
                .pageSize(pageSize)
                .keyword(keyword)
                .build();
    }
}
