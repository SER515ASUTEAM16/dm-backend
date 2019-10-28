package com.doodlemath.dmbackend.Controller;

import com.doodlemath.dmbackend.Model.User;
import com.doodlemath.dmbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
            return "Failed";

        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @PostMapping(path = "/loginByName")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String loginByName(@RequestBody User user) {
        if (user.getName() == null || user.getPassword() == null)
            return "failed";
        userRepository.findUserByName(user.getName(), user.getPassword());
        return "Saved";
    }

    @PostMapping(path = "/loginByEmail")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String loginByEmail(@RequestBody User user) {
        if (user.getPassword() == null || user.getEmail() == null)
            return "failed";
        userRepository.findUserByEmail(user.getEmail(), user.getPassword());
        return "Saved";
    }
}