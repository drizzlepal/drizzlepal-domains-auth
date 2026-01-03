package com.drizzlepal.domains.auth.infrastructure.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.drizzlepal.domains.auth.infrastructure.repository.table.UserTable;

@Mapper
public interface UserMapper extends BaseMapper<UserTable> {

}
