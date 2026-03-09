package com.drizzlepal.domains.auth.infrastructure.controller.dto.response;

import java.util.List;

import com.drizzlepal.domains.auth.api.dto.response.GetRolePageResponse;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "分页查询角色响应", description = "分页查询角色响应参数模型")
public class GetRolePageResponseDto implements DomainControllerResponse<GetRolePageResponse, GetRolePageResponseDto> {

    @Schema(description = "角色列表")
    private List<GetRoleResponseDto> records;

    @Schema(description = "总数")
    private Long total;

    @Schema(description = "页码")
    private Integer pageNum;

    @Schema(description = "每页数量")
    private Integer pageSize;

    @Override
    public GetRolePageResponseDto fromApiResponse(GetRolePageResponse apiResponse) {
        this.total = apiResponse.getTotal();
        this.pageNum = apiResponse.getPageNum();
        this.pageSize = apiResponse.getPageSize();
        if (apiResponse.getRecords() != null) {
            this.records = apiResponse.getRecords().stream()
                    .map(record -> {
                        GetRoleResponseDto dto = new GetRoleResponseDto();
                        dto.fromApiResponse(record);
                        return dto;
                    })
                    .toList();
        }
        return this;
    }
}
