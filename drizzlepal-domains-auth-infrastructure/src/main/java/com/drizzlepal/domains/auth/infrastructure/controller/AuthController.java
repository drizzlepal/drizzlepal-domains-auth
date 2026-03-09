package com.drizzlepal.domains.auth.infrastructure.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drizzlepal.domains.auth.api.AuthApi;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.request.UserLoginRequestDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.request.UserRegisterRequestDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.response.UserLoginResponseDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.response.UserRegisterResponseDto;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerRequest;
import com.drizzlepal.domains.common.infrastructure.controller.dto.DomainControllerResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@Tag(name = "认证接口", description = "提供用户登录、退出登录、获取用户信息等功能")
public class AuthController {

    private final AuthApi authApi;

    public AuthController(AuthApi authApi) {
        this.authApi = authApi;
    }

    @PostMapping("/register")
    @Operation(summary = "用户注册", description = "用户注册接口")
    public UserRegisterResponseDto registerUser(
            @Valid @RequestBody UserRegisterRequestDto userRegisterRequestDto) {
        return DomainControllerResponse.fromApiResponse(UserRegisterResponseDto.class,
                authApi.register(DomainControllerRequest.toApiRequest(userRegisterRequestDto)));
    }

    @PostMapping("/login")
    @Operation(summary = "用户登录", description = "用户登录接口，返回用户信息")
    public UserLoginResponseDto loginUser(@Valid @RequestBody UserLoginRequestDto userLoginRequest) {
        return DomainControllerResponse.fromApiResponse(UserLoginResponseDto.class,
                authApi.login(DomainControllerRequest.toApiRequest(userLoginRequest)));
    }

}
