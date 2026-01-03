package com.drizzlepal.domains.auth.bootstrap.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AuthLiquibaseConfig {

    @Value("${spring.profiles.active:false}")
    private String profilesActive;

    @Bean
    public SpringLiquibase authLiquibase(DataSource authDataSource) {
        log.info("开始配置数据库版本管理 Liquibase for Auth Module");
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:/db/liquibase/auth/master-changelog.xml");
        liquibase.setDataSource(authDataSource);
        liquibase.setShouldRun(true);
        liquibase.setDropFirst("dev".equals(profilesActive));
        log.info("完成数据库版本管理 Liquibase for Auth Module");
        return liquibase;
    }

}
