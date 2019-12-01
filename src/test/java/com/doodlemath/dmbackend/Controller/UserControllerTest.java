package com.doodlemath.dmbackend.Controller;

import com.doodlemath.dmbackend.Model.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserControllerTest {
    @Test
    public void addNewUserTest() {
        UserController userController = new UserController();

        //Return null when the email is null
        User userEmail = new User();
        userEmail.setEmail(null);
        Assert.assertNull(userController.addNewUser(userEmail));

        //Return null when the name is null
        User userName = new User();
        userName.setEmail(null);
        Assert.assertNull(userController.addNewUser(userName));

        //Return null when the name is null
        User userPassword = new User();
        userPassword.setEmail(null);
        Assert.assertNull(userController.addNewUser(userPassword));

        //Return null when the name is null
        User userRole = new User();
        userRole.setEmail(null);
        Assert.assertNull(userController.addNewUser(userRole));
    }
}