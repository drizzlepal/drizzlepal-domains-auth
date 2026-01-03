package com.drizzlepal.domains.auth.infrastructure.repository;

import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drizzlepal.domains.auth.domain.enums.UserStatus;
import com.drizzlepal.domains.auth.domain.model.User;
import com.drizzlepal.domains.auth.domain.repository.UserRepository;
import com.drizzlepal.domains.auth.exception.checked.UserIdGenerationFailedException;
import com.drizzlepal.domains.auth.infrastructure.repository.mapper.UserMapper;
import com.drizzlepal.domains.auth.infrastructure.repository.table.UserTable;
import de.huxhorn.sulky.ulid.ULID;

@Repository
public class UserRepositoryImpl extends ServiceImpl<UserMapper, UserTable> implements UserRepository {

    private static final ULID ulid = new ULID();

    @Override
    public Optional<User> findUserNotDeletedByUsername(String username) {
        UserTable one = getOne(Wrappers.lambdaQuery(UserTable.class).eq(UserTable::getName, username)
                .ne(UserTable::getStatus, UserStatus.DELETED));
        return Optional.ofNullable(one).map(this::toDomainUser);
    }

    @Override
    public void create(User user) throws UserIdGenerationFailedException {
        UserTable tableUser = toTableUser(user);
        int retryCount = 5;
        try {
            for (int i = 0; i < retryCount; i++) {
                tableUser.setId(ulid.nextULID());
                try {
                    baseMapper.insert(tableUser);
                    return;
                } catch (DuplicateKeyException e) {
                }
            }
        } catch (Exception e) {
            throw new UserIdGenerationFailedException(e);
        }
        throw new UserIdGenerationFailedException(retryCount);
    }

    private User toDomainUser(UserTable userTable) {
        return User.builder().id(userTable.getId()).name(userTable.getName()).password(userTable.getPassword())
                .createTime(userTable.getCreateTime()).email(userTable.getEmail()).mobile(userTable.getMobile())
                .organizationId(userTable.getOrganizationId()).status(userTable.getStatus())
                .updateTime(userTable.getUpdateTime()).build();
    }

    private UserTable toTableUser(User user) {
        UserTable userTable = new UserTable();
        userTable.setId(user.getId());
        userTable.setName(user.getName());
        userTable.setPassword(user.getPassword());
        userTable.setEmail(user.getEmail());
        userTable.setMobile(user.getMobile());
        userTable.setOrganizationId(user.getOrganizationId());
        userTable.setStatus(user.getStatus());
        userTable.setCreateTime(user.getCreateTime());
        userTable.setUpdateTime(user.getUpdateTime());
        return userTable;
    }

    @Override
    public boolean existsByNameForRegister(String username) {
        return exists(Wrappers.lambdaQuery(UserTable.class).eq(UserTable::getName, username));
    }

    @Override
    public boolean existsByNameForUpdate(String userId, String username) {
        return exists(Wrappers.lambdaQuery(UserTable.class).eq(UserTable::getName, username)
                .ne(UserTable::getId, userId));
    }

}
