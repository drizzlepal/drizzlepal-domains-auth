package com.drizzlepal.domains.auth.infrastructure.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drizzlepal.domains.auth.api.AuthApi;
import com.drizzlepal.domains.auth.api.dto.request.LoginRequest;
import com.drizzlepal.domains.auth.api.dto.request.RegisterRequest;
import com.drizzlepal.domains.auth.api.dto.response.LoginResponse;
import com.drizzlepal.domains.auth.api.dto.response.RegisterResponse;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.request.UserLoginRequestDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.request.UserRegisterRequestDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.response.UserLoginResponseDto;
import com.drizzlepal.domains.auth.infrastructure.controller.dto.response.UserRegisterResponseDto;

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
        RegisterResponse register = authApi.register(RegisterRequest.builder().build());
        UserRegisterResponseDto userRegisterResponseDto = UserRegisterResponseDto.fromDomain(register);
        return userRegisterResponseDto;
    }

    @PostMapping("/login")
    @Operation(summary = "用户登录", description = "用户登录接口，返回用户信息")
    public UserLoginResponseDto loginUser(@Valid @RequestBody UserLoginRequestDto userLoginRequest) {
        LoginResponse login = authApi.login(LoginRequest.builder().build());
        UserLoginResponseDto userLoginResponseDto = UserLoginResponseDto.fromDomain(login);
        return userLoginResponseDto;
    }

}
