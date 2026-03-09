package com.drizzlepal.domains.auth.infrastructure.controller.dto.response;

import java.util.List;

import com.drizzlepal.domains.auth.api.dto.response.GetUserPageResponse;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "分页查询用户响应", description = "分页查询用户响应体")
public class GetUserPageResponseDto implements DomainControllerResponse<GetUserPageResponse, GetUserPageResponseDto> {

    @Schema(description = "用户列表")
    private List<GetUserResponseDto> records;

    @Schema(description = "总数")
    private Long total;

    @Schema(description = "页码")
    private Integer pageNum;

    @Schema(description = "每页数量")
    private Integer pageSize;

    @Override
    public GetUserPageResponseDto fromApiResponse(GetUserPageResponse response) {
        if (response.getRecords() != null) {
            this.setRecords(response.getRecords().stream()
                    .map(r -> new GetUserResponseDto().fromApiResponse(r))
                    .toList());
        }
        this.setTotal(response.getTotal());
        this.setPageNum(response.getPageNum());
        this.setPageSize(response.getPageSize());
        return this;
    }
}
