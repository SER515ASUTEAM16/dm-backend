package com.doodlemath.dmbackend.Controller;

import com.doodlemath.dmbackend.Model.User;
import com.doodlemath.dmbackend.Repository.UserRepository;
import com.doodlemath.dmbackend.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Controller class maps the incoming requests to the respective business layer or database layer
 * Author : Vineeth Chitteti
 */
@Controller
@RequestMapping(path = "/auth")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/register")
    public @ResponseBody
    String addNewUser(@RequestBody User user) {
        if (user.getName() == null || user.getName().isEmpty() ||
                user.getPassword() == null || user.getPassword().isEmpty() ||
                user.getEmail() == null || user.getEmail().isEmpty() ||
                user.getRole() == null || user.getRole().isEmpty())
            return Constants.FAILED;

        userRepository.save(user);
        return Constants.SUCCESS;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path = "/allStudents")
    public @ResponseBody
    Iterable<User> getAllStudents() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @PostMapping(path = "/loginByName")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String loginByName(@RequestBody User user) {
        if (user.getName() == null || user.getPassword() == null)
            return Constants.FAILED;
        List<User> users = userRepository.findUserByName(user.getName(), user.getPassword());

        if(users == null || users.isEmpty())
            return Constants.FAILED;

        return Constants.SUCCESS;
    }

    @PostMapping(path = "/loginByEmail")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String loginByEmail(@RequestBody User user) {
        if (user.getPassword() == null || user.getEmail() == null)
            return Constants.FAILED;
        List<User> users = userRepository.findUserByEmail(user.getEmail(), user.getPassword());

        if(users == null || users.isEmpty())
            return Constants.FAILED;

        return Constants.SUCCESS;
    }
}