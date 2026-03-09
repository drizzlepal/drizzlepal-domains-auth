package com.drizzlepal.domains.auth.api;

import com.drizzlepal.domains.auth.api.dto.request.CreateRoleRequest;
import com.drizzlepal.domains.auth.api.dto.request.DeleteRoleRequest;
import com.drizzlepal.domains.auth.api.dto.request.GetRolePageRequest;
import com.drizzlepal.domains.auth.api.dto.request.GetRoleRequest;
import com.drizzlepal.domains.auth.api.dto.request.UpdateRoleRequest;
import com.drizzlepal.domains.auth.api.dto.response.CreateRoleResponse;
import com.drizzlepal.domains.auth.api.dto.response.GetRolePageResponse;
import com.drizzlepal.domains.auth.api.dto.response.GetRoleResponse;
import com.drizzlepal.domains.auth.api.dto.response.UpdateRoleResponse;

public interface RoleApi {

    CreateRoleResponse createRole(CreateRoleRequest request);

    GetRoleResponse getRole(GetRoleRequest request);

    UpdateRoleResponse updateRole(UpdateRoleRequest request);

    void deleteRole(DeleteRoleRequest request);

    GetRolePageResponse getRolePage(GetRolePageRequest request);
}
