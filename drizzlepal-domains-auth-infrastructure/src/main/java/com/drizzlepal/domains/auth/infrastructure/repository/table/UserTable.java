package com.drizzlepal.domains.auth.infrastructure.repository.table;

import java.util.Set;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.drizzlepal.domains.auth.domain.model.Role;
import com.drizzlepal.domains.auth.domain.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户表映射类
 * 用于表示数据库中的用户表结构，包含用户的基本属性和时间戳信息
 */
@Data
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserTable extends User {

    /**
     * 用户ID
     */
    @TableId(type = IdType.INPUT)
    private String id;

    /**
     * 用户角色列表
     */
    @TableField(exist = false)
    private Set<Role> roles;

}
