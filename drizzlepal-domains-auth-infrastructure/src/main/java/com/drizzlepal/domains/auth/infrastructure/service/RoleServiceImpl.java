package com.drizzlepal.domains.auth.infrastructure.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.drizzlepal.domains.auth.api.RoleApi;
import com.drizzlepal.domains.auth.api.dto.request.CreateRoleRequest;
import com.drizzlepal.domains.auth.api.dto.request.DeleteRoleRequest;
import com.drizzlepal.domains.auth.api.dto.request.GetRolePageRequest;
import com.drizzlepal.domains.auth.api.dto.request.GetRoleRequest;
import com.drizzlepal.domains.auth.api.dto.request.UpdateRoleRequest;
import com.drizzlepal.domains.auth.api.dto.response.CreateRoleResponse;
import com.drizzlepal.domains.auth.api.dto.response.GetRolePageResponse;
import com.drizzlepal.domains.auth.api.dto.response.GetRoleResponse;
import com.drizzlepal.domains.auth.api.dto.response.UpdateRoleResponse;
import com.drizzlepal.domains.auth.domain.model.Role;
import com.drizzlepal.domains.auth.domain.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleApi {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public CreateRoleResponse createRole(CreateRoleRequest request) {
        Role role = Role.builder()
                .id(java.util.UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .permissionIds(request.getPermissionIds())
                .createTime(new Date())
                .updateTime(new Date())
                .build();
        roleRepository.create(role);
        return CreateRoleResponse.builder().roleId(role.getId()).build();
    }

    @Override
    public GetRoleResponse getRole(GetRoleRequest request) {
        Role role = roleRepository.findById(request.getId()).orElse(null);
        if (role == null) {
            return null;
        }
        return GetRoleResponse.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .permissionIds(role.getPermissionIds())
                .createTime(role.getCreateTime())
                .updateTime(role.getUpdateTime())
                .build();
    }

    @Override
    public UpdateRoleResponse updateRole(UpdateRoleRequest request) {
        Role existing = roleRepository.findById(request.getId()).orElse(null);
        if (existing == null) {
            return null;
        }
        Role updated = Role.builder()
                .id(existing.getId())
                .name(request.getName() != null ? request.getName() : existing.getName())
                .description(request.getDescription() != null ? request.getDescription() : existing.getDescription())
                .permissionIds(request.getPermissionIds() != null
                        ? request.getPermissionIds() : existing.getPermissionIds())
                .createTime(existing.getCreateTime())
                .updateTime(new Date())
                .build();
        roleRepository.update(updated);
        return UpdateRoleResponse.builder()
                .id(updated.getId())
                .name(updated.getName())
                .description(updated.getDescription())
                .permissionIds(updated.getPermissionIds())
                .createTime(updated.getCreateTime())
                .updateTime(updated.getUpdateTime())
                .build();
    }

    @Override
    public void deleteRole(DeleteRoleRequest request) {
        roleRepository.delete(request.getId());
    }

    @Override
    public GetRolePageResponse getRolePage(GetRolePageRequest request) {
        List<Role> allRoles = roleRepository.findAll();

        // Filter by keyword
        if (request.getKeyword() != null && !request.getKeyword().isEmpty()) {
            String keyword = request.getKeyword().toLowerCase();
            allRoles = allRoles.stream()
                    .filter(r -> r.getName().toLowerCase().contains(keyword)
                            || (r.getDescription() != null && r.getDescription().toLowerCase().contains(keyword)))
                    .collect(Collectors.toList());
        }

        long total = allRoles.size();

        // Pagination
        int pageNum = request.getPageNum() != null ? request.getPageNum() : 1;
        int pageSize = request.getPageSize() != null ? request.getPageSize() : 10;
        int start = (pageNum - 1) * pageSize;
        int end = Math.min(start + pageSize, allRoles.size());

        List<Role> pagedRoles = start < allRoles.size() ? allRoles.subList(start, end) : List.of();

        List<GetRoleResponse> records = pagedRoles.stream()
                .map(r -> GetRoleResponse.builder()
                        .id(r.getId())
                        .name(r.getName())
                        .description(r.getDescription())
                        .permissionIds(r.getPermissionIds())
                        .createTime(r.getCreateTime())
                        .updateTime(r.getUpdateTime())
                        .build())
                .collect(Collectors.toList());

        return GetRolePageResponse.builder()
                .records(records)
                .total(total)
                .pageNum(pageNum)
                .pageSize(pageSize)
                .build();
    }
}
