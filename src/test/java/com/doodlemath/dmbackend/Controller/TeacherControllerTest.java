package com.doodlemath.dmbackend.Controller;

import com.doodlemath.dmbackend.Repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class TeacherControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    TeacherController teacherController;

    @Before
    public void setup() {

    }

    @Test
    public void getAllStudents() throws Exception {
        when(userRepository.findAllStudents(Mockito.any())).thenReturn(null);
        Assert.assertNull(teacherController.getAllStudents("1-5"));
    }

    @Test
    public void addStudentToCourse() throws Exception {
    }

    @Test
    public void addStudentToCourse1() throws Exception {
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
