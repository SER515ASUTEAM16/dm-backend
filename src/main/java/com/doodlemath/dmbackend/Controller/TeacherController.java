package com.doodlemath.dmbackend.Controller;

import com.doodlemath.dmbackend.Model.Assignment;
import com.doodlemath.dmbackend.Repository.AssignmentRepository;
import com.doodlemath.dmbackend.constants.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doodlemath.dmbackend.Model.User;
import com.doodlemath.dmbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Autowired
    private AssignmentRepository assignmentRepository;

    @CrossOrigin
    @GetMapping(path = "/getAllStudentsInGrade/{grade}")
    public @ResponseBody
    Iterable<User> getAllStudents(@PathVariable String grade) {
        return userRepository.findAllStudents(grade);
    }

    @CrossOrigin
    @GetMapping(path = "/registerStudent")
    public @ResponseBody
    Iterable<User> addStudentToCourse(@RequestBody User user) {
        return userRepository.findAll();
    }

    @CrossOrigin
    @PostMapping(path = "/createAssignment")
    public @ResponseBody
    String createAssignment(@RequestBody Assignment assignment) {
        if(assignment.getAuthor() == null || assignment.getAuthor().isEmpty())
            return Constants.FAILED;

        if(assignment.getName() == null || assignment.getName().isEmpty())
            return Constants.FAILED;

        assignmentRepository.save(assignment);

        return Constants.SUCCESS;
    }

    @CrossOrigin
    @GetMapping(path = "/getAssignments/{authorName}")
    public @ResponseBody
    List<Assignment> getAssignments(@PathVariable String authorName) {
        List<Assignment> assignment = assignmentRepository.findAssignmentsCreatedByAuthor(authorName);
        return assignment;
    }

    @CrossOrigin
    @GetMapping(path = "/getAllAssignments")
    public @ResponseBody
    List<Assignment> getAssignments() {
        List<Assignment> assignmentList = new ArrayList<>();
        Iterable<Assignment> assignments = assignmentRepository.findAll();

        Iterator<Assignment> iterator = assignments.iterator();
        while(iterator.hasNext()) {
            assignmentList.add(iterator.next());
        }

        return assignmentList;
    }
}