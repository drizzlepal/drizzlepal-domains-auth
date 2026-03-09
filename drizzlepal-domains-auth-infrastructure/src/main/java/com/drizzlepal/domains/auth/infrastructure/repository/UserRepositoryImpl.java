package com.drizzlepal.domains.auth.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drizzlepal.domains.auth.domain.enums.UserStatus;
import com.drizzlepal.domains.auth.domain.model.User;
import com.drizzlepal.domains.auth.domain.repository.UserRepository;
import com.drizzlepal.domains.auth.infrastructure.repository.mapper.UserMapper;
import com.drizzlepal.domains.auth.infrastructure.repository.table.UserTable;
import de.huxhorn.sulky.ulid.ULID;

@Repository
public class UserRepositoryImpl extends ServiceImpl<UserMapper, UserTable> implements UserRepository {

    private static final ULID ulid = new ULID();

    @Override
    public Optional<User> findById(String id) {
        UserTable table = getById(id);
        return Optional.ofNullable(table).map(this::toDomainUser);
    }

    @Override
    public Optional<User> findUserNotDeletedByUsername(String username) {
        UserTable one = getOne(Wrappers.lambdaQuery(UserTable.class).eq(UserTable::getName, username)
                .ne(UserTable::getStatus, UserStatus.DELETED));
        return Optional.ofNullable(one).map(this::toDomainUser);
    }

    @Override
    public List<User> findAll() {
        return list().stream().map(this::toDomainUser).toList();
    }

    @Override
    public void create(User user) {
        UserTable tableUser = toTableUser(user);
        tableUser.setId(ulid.nextULID());
        baseMapper.insert(tableUser);
    }

    @Override
    public void update(User user) {
        UserTable tableUser = toTableUser(user);
        updateById(tableUser);
    }

    @Override
    public void delete(String id) {
        removeById(id);
    }

    private User toDomainUser(UserTable userTable) {
        return User.builder()
                .id(userTable.getId())
                .name(userTable.getName())
                .username(userTable.getName())
                .password(userTable.getPassword())
                .email(userTable.getEmail())
                .mobile(userTable.getMobile())
                .organizationId(userTable.getOrganizationId())
                .status(userTable.getStatus())
                .createTime(userTable.getCreateTime())
                .updateTime(userTable.getUpdateTime())
                .build();
    }

    private UserTable toTableUser(User user) {
        UserTable userTable = new UserTable();
        userTable.setId(user.getId());
        userTable.setName(user.getUsername());
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
