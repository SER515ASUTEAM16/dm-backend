package com.doodlemath.dmbackend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * A basic controller to check the health of the application
 * Author : Vineeth Chitteti
 */
@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "good";
    }
}
