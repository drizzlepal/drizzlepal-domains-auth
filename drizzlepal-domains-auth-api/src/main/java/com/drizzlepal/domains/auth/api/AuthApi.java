package com.drizzlepal.domains.auth.api;

import com.drizzlepal.domains.auth.api.dto.request.LoginRequest;
import com.drizzlepal.domains.auth.api.dto.request.RegisterRequest;
import com.drizzlepal.domains.auth.api.dto.response.LoginResponse;
import com.drizzlepal.domains.auth.api.dto.response.RegisterResponse;

public interface AuthApi {

    LoginResponse login(LoginRequest LoginRequest);

    RegisterResponse register(RegisterRequest registerRequest);

}
