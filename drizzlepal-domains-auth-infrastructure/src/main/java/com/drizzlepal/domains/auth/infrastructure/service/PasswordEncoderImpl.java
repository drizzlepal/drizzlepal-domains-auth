package com.drizzlepal.domains.auth.infrastructure.service;

import org.springframework.stereotype.Service;

import com.drizzlepal.crypto.MessageDigests;
import com.drizzlepal.crypto.MessageDigests.HmacAlgorithm;
import com.drizzlepal.crypto.exception.CryptoErrorException;
import com.drizzlepal.domains.auth.domain.port.PasswordEncoder;
import com.drizzlepal.domains.auth.exception.DataCryptoException;

@Service
public class PasswordEncoderImpl implements PasswordEncoder {

    @Override
    public String encode(String rawPassword) {
        return digestPassword(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return digestPassword(rawPassword).equals(encodedPassword);
    }

    private static String digestPassword(String password) {
        try {
            return MessageDigests.hmac(HmacAlgorithm.HMAC_SHA512, passwordDigestKeyPrefix() + password, password);
        } catch (CryptoErrorException e) {
            throw new DataCryptoException("新用户密码加密存储失败: 密码摘要计算失败", e);
        }
    }

    private static String passwordDigestKeyPrefix() {
        return "drizzlepal-domain-auth-user-password-digests-key-95271156-";
    }

}
