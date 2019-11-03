package com.doodlemath.dmbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot application starter class. Start the application using the main method defined in this class.
 * Author : Vineeth Chitteti
 */
@SpringBootApplication(scanBasePackages={"com.doodlemath.dmbackend"})
@EnableAutoConfiguration
public class DmBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmBackendApplication.class, args);
    }

}
