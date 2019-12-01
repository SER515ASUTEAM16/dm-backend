package com.doodlemath.dmbackend.Controller;

import com.doodlemath.dmbackend.Model.Assignment;
import com.doodlemath.dmbackend.Model.StudentAssignment;
import com.doodlemath.dmbackend.Repository.AssignmentRepository;
import com.doodlemath.dmbackend.Repository.StudentAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentAssignmentRepository studentAssignmentRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @CrossOrigin
    @GetMapping(path = "/{studentName}/getAssignments")
    public @ResponseBody
    List<StudentAssignment> getAssignments(@PathVariable String studentName) {
        List<StudentAssignment> assignments = studentAssignmentRepository.findAssignmentsByStudentName(studentName);
        return assignments;
    }

    @CrossOrigin
    @GetMapping(path = "/assignment/{assignmentID}")
    public @ResponseBody
    Assignment getAssignment(@PathVariable Integer assignmentID) {
        Optional optional = assignmentRepository.findById(assignmentID);
        Assignment assignment = null;
        if(optional.isPresent())
            assignment = (Assignment) optional.get();

        return assignment;
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