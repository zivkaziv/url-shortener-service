package com.shortenerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.shortenercommon"})
@EntityScan({"com.shortenercommon"})
@EnableJpaRepositories(basePackages = {"com.shortenercommon"})
public class ShortenerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortenerServiceApplication.class, args);
    }

}
