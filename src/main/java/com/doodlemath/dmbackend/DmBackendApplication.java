package com.doodlemath.dmbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.doodlemath.dmbackend"})
@EnableAutoConfiguration
public class DmBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmBackendApplication.class, args);
    }

}
