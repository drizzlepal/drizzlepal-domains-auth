package com.drizzlepal.domains.auth.api;

import com.drizzlepal.domains.auth.api.dto.request.CreateUserRequest;
import com.drizzlepal.domains.auth.api.dto.request.DeleteUserRequest;
import com.drizzlepal.domains.auth.api.dto.request.GetUserByUsernameRequest;
import com.drizzlepal.domains.auth.api.dto.request.GetUserPageRequest;
import com.drizzlepal.domains.auth.api.dto.request.GetUserRequest;
import com.drizzlepal.domains.auth.api.dto.request.UpdateUserRequest;
import com.drizzlepal.domains.auth.api.dto.response.CreateUserResponse;
import com.drizzlepal.domains.auth.api.dto.response.GetUserPageResponse;
import com.drizzlepal.domains.auth.api.dto.response.GetUserResponse;
import com.drizzlepal.domains.auth.api.dto.response.UpdateUserResponse;

public interface UserApi {

    CreateUserResponse createUser(CreateUserRequest request);

    GetUserResponse getUser(GetUserRequest request);

    GetUserResponse getUserByUsername(GetUserByUsernameRequest request);

    UpdateUserResponse updateUser(UpdateUserRequest request);

    void deleteUser(DeleteUserRequest request);

    GetUserPageResponse getUserPage(GetUserPageRequest request);
}
