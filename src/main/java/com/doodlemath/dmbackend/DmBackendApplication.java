package com.doodlemath.dmbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.doodlemath.dmbackend"})
@EnableAutoConfiguration
public class DmBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmBackendApplication.class, args);
    }

}
