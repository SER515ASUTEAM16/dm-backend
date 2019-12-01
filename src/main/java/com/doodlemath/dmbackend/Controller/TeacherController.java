package com.doodlemath.dmbackend.Controller;

import com.doodlemath.dmbackend.Model.Assignment;
import com.doodlemath.dmbackend.Model.StudentAssignment;
import com.doodlemath.dmbackend.Model.StudentDetails;
import com.doodlemath.dmbackend.Repository.AssignmentRepository;
import com.doodlemath.dmbackend.Repository.StudentAssignmentRepository;
import com.doodlemath.dmbackend.Repository.StudentTeacherRepository;
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

    @Autowired
    private StudentTeacherRepository studentTeacherRepository;

    @Autowired
    private StudentAssignmentRepository studentAssignmentRepository;

    @CrossOrigin
    @GetMapping(path = "/getAllStudentsInGrade/{grade}")
    public @ResponseBody
    Iterable<User> getAllStudents(@PathVariable String grade) {
        return userRepository.findAllStudents(grade);
    }

    @CrossOrigin
    @PostMapping(path = "/{teacherName}/registerStudents")
    public @ResponseBody
    String addStudentToCourse(@PathVariable String teacherName, @RequestBody List<User> users) {
        List<StudentDetails> studentDetailsList = new ArrayList<>(users.size());
        for(User user : users) {
            StudentDetails studentDetails = new StudentDetails();
            studentDetails.setEmail(user.getEmail());
            studentDetails.setName(user.getName());
            studentDetails.setTeacher(teacherName);
            studentDetailsList.add(studentDetails);
        }
        studentTeacherRepository.saveAll(studentDetailsList);

        return Constants.SUCCESS;
    }

    @CrossOrigin
    @GetMapping(path = "/{teacherName}/registeredStudents")
    public @ResponseBody
    List<StudentDetails> addStudentToCourse(@PathVariable String teacherName) {
        return studentTeacherRepository.findByTeacherName(teacherName);
    }

    @CrossOrigin
    @PostMapping(path = "/createAssignment")
    public @ResponseBody
    Assignment createAssignment(@RequestBody Assignment assignment) {
        if(assignment.getAuthor() == null || assignment.getAuthor().isEmpty())
            return null;

        Assignment createdAssignment = assignmentRepository.save(assignment);
        List<User> users = userRepository.findAllStudents(assignment.getGrade());

        for(User user : users) {
            StudentAssignment studentAssignment = new StudentAssignment();
            studentAssignment.setEmail(user.getEmail());
            studentAssignment.setName(user.getName());
            studentAssignment.setAssignmentID(createdAssignment.getId());
            studentAssignment.setTitle(createdAssignment.getTitle());
            studentAssignment.setDescription(createdAssignment.getDescription());
            studentAssignment.setDueDate(createdAssignment.getDeadline());
            studentAssignmentRepository.save(studentAssignment);
        }

        return createdAssignment;
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