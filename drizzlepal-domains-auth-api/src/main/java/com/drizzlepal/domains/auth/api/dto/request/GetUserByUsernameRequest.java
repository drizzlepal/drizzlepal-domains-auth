package com.drizzlepal.domains.auth.api.dto.request;

import com.drizzlepal.domains.common.api.dto.DomainApiRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserByUsernameRequest implements DomainApiRequest {

    private String username;
}
