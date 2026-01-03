package com.drizzlepal.domains.auth.application.result;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResult {

    private String token;

}
