package com.doodlemath.dmbackend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping(path = "/teacher")
public class TeacherController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/getAllStudentsInGrade")
    public @ResponseBody
    Iterable<User> getAllStudents(@RequestBody User user) {
        return userRepository.findAllStudents(user.getGrade());
    }

    @GetMapping(path = "/students")
    public @ResponseBody
    Iterable<User> addStudentToCourse(@RequestBody User user) {

        return userRepository.findAll();
    }
}