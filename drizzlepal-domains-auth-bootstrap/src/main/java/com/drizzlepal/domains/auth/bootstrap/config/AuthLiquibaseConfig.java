package com.drizzlepal.domains.auth.bootstrap.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AuthLiquibaseConfig {

    @Bean
    public SpringLiquibase authLiquibase(DataSource dataSource) {
        log.info("开始配置数据库版本管理 Liquibase for Auth Module");
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:/db/liquibase/auth/master-changelog.xml");
        liquibase.setDataSource(dataSource);
        liquibase.setShouldRun(true);
        log.info("完成数据库版本管理 Liquibase for Auth Module");
        return liquibase;
    }

}
