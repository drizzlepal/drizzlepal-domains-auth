package com.drizzlepal.domains.auth.bootstrap.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableTransactionManagement
public class AuthDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.auth")
    public DataSourceProperties authDataSourceProperties() {
        log.info("Auth DataSource Configuration");
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.auth.configuration")
    public HikariDataSource authDataSource(
            @Qualifier("authDataSourceProperties") DataSourceProperties authDataSourceProperties) {
        log.info("Auth DataSource Configuration");
        return authDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

}
