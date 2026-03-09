package com.drizzlepal.domains.auth.bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.drizzlepal.domains.auth")
@MapperScan(basePackages = "com.drizzlepal.domains.auth.infrastructure.repository.mapper")
public class DrizzlepalDomainsAuthBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(DrizzlepalDomainsAuthBootStrap.class, args);
    }
}
