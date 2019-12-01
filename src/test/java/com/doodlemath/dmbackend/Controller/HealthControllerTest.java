package com.doodlemath.dmbackend.Controller;

import org.junit.Assert;
import org.junit.Test;


public class HealthControllerTest {

    @Test
    public void health() throws Exception {
        HealthController healthController = new HealthController();

        //Test that health returns health when app is up and running
        Assert.assertEquals(healthController.health(), "good");
    }
}