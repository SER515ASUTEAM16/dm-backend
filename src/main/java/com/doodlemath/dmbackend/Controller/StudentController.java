package com.doodlemath.dmbackend.Controller;

import com.doodlemath.dmbackend.Model.StudentAssignment;
import com.doodlemath.dmbackend.Repository.StudentAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentAssignmentRepository studentAssignmentRepository;

    @CrossOrigin
    @GetMapping(path = "/{studentName}/getAssignments")
    public @ResponseBody
    List<StudentAssignment> getAssignments(@PathVariable String studentName) {
        List<StudentAssignment> assignments = studentAssignmentRepository.findAssignmentsByStudentName(studentName);
        return assignments;
    }

    @CrossOrigin
    @PostMapping(path = "/{studentName}/submitAssignment")
    public @ResponseBody
    StudentAssignment submitAssignment(@PathVariable String studentName, @RequestBody StudentAssignment studentAssignment) {
        List<StudentAssignment> assignments = studentAssignmentRepository.findAssignmentsByStudentNameAssignmentID(studentName, studentAssignment.getAssignmentID());
        StudentAssignment studentAssignmentUpdatable = assignments.get(0);
        studentAssignmentUpdatable.setResult(studentAssignment.getResult());
        StudentAssignment studentAssignmentUpdated = studentAssignmentRepository.save(studentAssignmentUpdatable);
        return studentAssignmentUpdated;
    }
}