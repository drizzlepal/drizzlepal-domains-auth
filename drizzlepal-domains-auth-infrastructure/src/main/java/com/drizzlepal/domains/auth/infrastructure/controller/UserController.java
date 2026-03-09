package com.drizzlepal.domains.auth.infrastructure.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drizzlepal.domains.auth.api.UserApi;
import com.drizzlepal.domains.auth.api.dto.request.GetUserRequest;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.request.CreateUserRequestDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.request.DeleteUserRequestDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.request.GetUserByUsernameRequestDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.request.GetUserPageRequestDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.request.GetUserRequestDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.request.UpdateUserRequestDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.response.CreateUserResponseDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.response.GetUserPageResponseDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.response.GetUserResponseDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.response.UpdateUserResponseDto;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerRequest;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@Tag(name = "用户接口", description = "提供用户相关的操作")
public class UserController {

    private final UserApi userApi;

    public UserController(UserApi userApi) {
        this.userApi = userApi;
    }

    @PostMapping("/page")
    @Operation(summary = "分页查询用户", description = "分页查询用户接口")
    public GetUserPageResponseDto getUserPage(@Valid @RequestBody GetUserPageRequestDto request) {
        return DomainControllerResponse.fromApiResponse(GetUserPageResponseDto.class,
                userApi.getUserPage(DomainControllerRequest.toApiRequest(request)));
    }

    @PostMapping("/create")
    @Operation(summary = "创建用户", description = "创建新用户")
    public CreateUserResponseDto createUser(@Valid @RequestBody CreateUserRequestDto request) {
        return DomainControllerResponse.fromApiResponse(CreateUserResponseDto.class,
                userApi.createUser(DomainControllerRequest.toApiRequest(request)));
    }

    @PostMapping("/delete")
    @Operation(summary = "删除用户", description = "删除用户接口")
    public void deleteUser(@Valid @RequestBody DeleteUserRequestDto request) {
        userApi.deleteUser(DomainControllerRequest.toApiRequest(request));
    }

    @PostMapping("/update")
    @Operation(summary = "更新用户", description = "更新用户接口")
    public UpdateUserResponseDto updateUser(@Valid @RequestBody UpdateUserRequestDto request) {
        return DomainControllerResponse.fromApiResponse(UpdateUserResponseDto.class,
                userApi.updateUser(DomainControllerRequest.toApiRequest(request)));
    }

    @PostMapping("/get")
    @Operation(summary = "获取用户", description = "获取用户接口")
    public GetUserResponseDto getUser(@Valid @RequestBody GetUserRequestDto request) {
        return DomainControllerResponse.fromApiResponse(GetUserResponseDto.class,
                userApi.getUser(DomainControllerRequest.toApiRequest(request)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取用户", description = "根据ID获取用户")
    public GetUserResponseDto getUserById(@PathVariable String id) {
        GetUserRequest request = GetUserRequest.builder().id(id).build();
        return DomainControllerResponse.fromApiResponse(GetUserResponseDto.class,
                userApi.getUser(request));
    }

    @GetMapping("/username/{username}")
    @Operation(summary = "获取用户", description = "根据用户名获取用户")
    public GetUserResponseDto getUserByUsername(@PathVariable String username) {
        GetUserByUsernameRequestDto requestDto = new GetUserByUsernameRequestDto();
        requestDto.setUsername(username);
        return DomainControllerResponse.fromApiResponse(GetUserResponseDto.class,
                userApi.getUserByUsername(DomainControllerRequest.toApiRequest(requestDto)));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "更新用户", description = "根据ID更新用户")
    public UpdateUserResponseDto updateUserById(@PathVariable String id,
            @Valid @RequestBody UpdateUserRequestDto request) {
        request.setId(id);
        return DomainControllerResponse.fromApiResponse(UpdateUserResponseDto.class,
                userApi.updateUser(request.toApiRequest()));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户", description = "根据ID删除用户")
    public void deleteUserById(@PathVariable String id) {
        DeleteUserRequestDto requestDto = new DeleteUserRequestDto();
        requestDto.setId(id);
        userApi.deleteUser(DomainControllerRequest.toApiRequest(requestDto));
    }
}
