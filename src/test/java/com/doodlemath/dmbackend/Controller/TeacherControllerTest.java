package com.doodlemath.dmbackend.Controller;

import com.doodlemath.dmbackend.Model.User;
import com.doodlemath.dmbackend.Repository.StudentTeacherRepository;
import com.doodlemath.dmbackend.Repository.UserRepository;
import com.doodlemath.dmbackend.constants.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class TeacherControllerTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private StudentTeacherRepository studentTeacherRepository;

    @InjectMocks
    TeacherController teacherController;

    List<User> students;

    @Before
    public void setup() {
        students = new ArrayList<>();

        //Registered 2 students
        students.add(new User());
        students.add(new User());
    }

    @Test
    public void getAllStudents() throws Exception {
        //Return students in a particular grade
        when(userRepository.findAllStudents(Mockito.any())).thenReturn(students);

        Assert.assertNotNull(teacherController.getAllStudents("1-5"));
    }

    @Test
    public void testWhenNoUserIsRegisteredReturnNull() throws Exception {
        //When repository doesn't have students do not return any students
        when(userRepository.findAllStudents(Mockito.any())).thenReturn(null);
        Assert.assertNull(teacherController.getAllStudents("1-5"));
    }

    @Test
    public void addStudentToCourse() throws Exception {
        when(studentTeacherRepository.save(Mockito.any())).thenReturn(null);

        //Return success upon adding students to the course
        Assert.assertEquals(teacherController.addStudentToCourse("teacherName", students), Constants.SUCCESS);
    }

    @Test
    public void createAssignment() throws Exception {
    }

    @Test
    public void getAssignments() throws Exception {
    }

    @Test
    public void getAssignments1() throws Exception {
    }
}
