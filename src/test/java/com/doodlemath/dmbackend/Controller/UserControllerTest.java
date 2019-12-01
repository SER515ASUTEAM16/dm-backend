package com.doodlemath.dmbackend.Controller;

import com.doodlemath.dmbackend.Model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserControllerTest {
    UserController userController;

    @Before
    public void setup() {
        userController = new UserController();
    }

    @Test
    public void addNewUserTestWithNullEmail() {
        //Return null when the email is null
        User userEmail = new User();
        userEmail.setEmail(null);
        Assert.assertNull(userController.addNewUser(userEmail));
    }

    @Test
    public void addNewUserTestWithNullName() {
        //Return null when the email is null
        User userEmail = new User();
        userEmail.setName(null);
        Assert.assertNull(userController.addNewUser(userEmail));
    }

    @Test
    public void addNewUserTestWithNullPassword() {
        //Return null when the email is null
        User userEmail = new User();
        userEmail.setPassword(null);
        Assert.assertNull(userController.addNewUser(userEmail));
    }

    @Test
    public void addNewUserTestWithNullRole() {
        //Return null when the email is null
        User userEmail = new User();
        userEmail.setRole(null);
        Assert.assertNull(userController.addNewUser(userEmail));
    }
}