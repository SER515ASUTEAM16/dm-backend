package com.doodlemath.dmbackend.Controller;

import com.doodlemath.dmbackend.Model.User;
import org.junit.Assert;
import org.junit.Test;

public class StudentControllerTest {

    @Test
    public void addNewUserTestWithoutEmail() {
        UserController userController = new UserController();
        //Return null when the email is null
        User userEmail = new User();
        userEmail.setEmail(null);
        Assert.assertNull(userController.addNewUser(userEmail));
    }

    @Test
    public void addNewUserTestWithoutRole() {
        UserController userController = new UserController();
        //Return null when the email is null
        User userEmail = new User();
        userEmail.setEmail(null);
        Assert.assertNull(userController.addNewUser(userEmail));
    }

    @Test
    public void addNewUserTestWithoutPassword() {
        UserController userController = new UserController();
        //Return null when the email is null
        User userEmail = new User();
        userEmail.setPassword(null);
        Assert.assertNull(userController.addNewUser(userEmail));
    }

    @Test
    public void addNewUserTestWithoutName() {
        UserController userController = new UserController();
        //Return null when the email is null
        User userEmail = new User();
        userEmail.setName(null);
        Assert.assertNull(userController.addNewUser(userEmail));
    }
}
