package com.redirectservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.shortenercommon"})
@ComponentScan(basePackages ={"com.shortenercommon","com.redirectservice"})
@EntityScan({"com"})
public class RedirectServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedirectServiceApplication.class, args);
    }
}
