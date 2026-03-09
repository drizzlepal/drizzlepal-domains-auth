package com.drizzlepal.domains.auth.domain.model;

import java.util.Date;
import java.util.Set;

import com.drizzlepal.domains.auth.domain.port.PasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 * 用于表示系统中的用户信息，包含用户的基本属性和状态信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * 用户唯一标识符
     */
    private String id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户名（登录账号）
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户邮箱地址
     */
    private String email;

    /**
     * 用户手机号码
     */
    private String mobile;

    /**
     * 用户所属组织机构ID
     */
    private String organizationId;

    /**
     * 用户角色ID
     */
    private String roleId;

    /**
     * 用户状态
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 用户角色列表
     */
    private Set<Role> roles;

    public boolean verifyPassword(String encodedPassword, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(password, encodedPassword);
    }
}
