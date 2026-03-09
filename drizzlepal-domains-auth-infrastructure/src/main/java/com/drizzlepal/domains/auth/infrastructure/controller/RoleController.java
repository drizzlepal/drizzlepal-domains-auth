package com.drizzlepal.domains.auth.infrastructure.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drizzlepal.domains.auth.api.RoleApi;
import com.drizzlepal.domains.auth.api.dto.request.GetRoleRequest;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.request.CreateRoleRequestDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.request.DeleteRoleRequestDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.request.GetRolePageRequestDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.request.GetRoleRequestDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.request.UpdateRoleRequestDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.response.CreateRoleResponseDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.response.GetRolePageResponseDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.response.GetRoleResponseDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.response.UpdateRoleResponseDto;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerRequest;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/roles")
@Tag(name = "角色接口", description = "提供角色相关的操作")
public class RoleController {

    private final RoleApi roleApi;

    public RoleController(RoleApi roleApi) {
        this.roleApi = roleApi;
    }

    @PostMapping("/page")
    @Operation(summary = "分页查询角色", description = "分页查询角色接口")
    public GetRolePageResponseDto getRolePage(@Valid @RequestBody GetRolePageRequestDto request) {
        return DomainControllerResponse.fromApiResponse(GetRolePageResponseDto.class,
                roleApi.getRolePage(DomainControllerRequest.toApiRequest(request)));
    }

    @PostMapping("/create")
    @Operation(summary = "创建角色", description = "创建新角色")
    public CreateRoleResponseDto createRole(@Valid @RequestBody CreateRoleRequestDto request) {
        return CreateRoleResponseDto.fromDomain(roleApi.createRole(DomainControllerRequest.toApiRequest(request)));
    }

    @PostMapping("/delete")
    @Operation(summary = "删除角色", description = "删除角色接口")
    public void deleteRole(@Valid @RequestBody DeleteRoleRequestDto request) {
        roleApi.deleteRole(DomainControllerRequest.toApiRequest(request));
    }

    @PostMapping("/update")
    @Operation(summary = "更新角色", description = "更新角色接口")
    public UpdateRoleResponseDto updateRole(@Valid @RequestBody UpdateRoleRequestDto request) {
        return DomainControllerResponse.fromApiResponse(UpdateRoleResponseDto.class,
                roleApi.updateRole(DomainControllerRequest.toApiRequest(request)));
    }

    @PostMapping("/get")
    @Operation(summary = "获取角色", description = "获取角色接口")
    public GetRoleResponseDto getRole(@Valid @RequestBody GetRoleRequestDto request) {
        return DomainControllerResponse.fromApiResponse(GetRoleResponseDto.class,
                roleApi.getRole(DomainControllerRequest.toApiRequest(request)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取角色", description = "根据ID获取角色")
    public GetRoleResponseDto getRoleById(@PathVariable String id) {
        GetRoleRequest request = GetRoleRequest.builder().id(id).build();
        return DomainControllerResponse.fromApiResponse(GetRoleResponseDto.class,
                roleApi.getRole(request));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "更新角色", description = "根据ID更新角色")
    public UpdateRoleResponseDto updateRoleById(@PathVariable String id,
            @Valid @RequestBody UpdateRoleRequestDto request) {
        request.setId(id);
        return DomainControllerResponse.fromApiResponse(UpdateRoleResponseDto.class,
                roleApi.updateRole(request.toApiRequest()));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除角色", description = "根据ID删除角色")
    public void deleteRoleById(@PathVariable String id) {
        DeleteRoleRequestDto requestDto = new DeleteRoleRequestDto();
        requestDto.setId(id);
        roleApi.deleteRole(DomainControllerRequest.toApiRequest(requestDto));
    }
}
