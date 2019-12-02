package com.doodlemath.dmbackend.Repository;

import com.doodlemath.dmbackend.Model.StudentAssignment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentAssignmentRepository extends CrudRepository<StudentAssignment, Integer> {

    @Query("Select u from StudentAssignment u where LOWER(u.name) = LOWER(:name)")
    List<StudentAssignment> findAssignmentsByStudentName(@Param("name") String name);

    @Query("Select u from StudentAssignment u where LOWER(u.email) = LOWER(:email)")
    List<StudentAssignment> findAssignmentByStudentEmail(@Param("email") String email);

    @Query("Select u from StudentAssignment u where LOWER(u.name) = LOWER(:name) and u.assignmentID = :assignmentID")
    List<StudentAssignment> findAssignmentsByStudentNameAssignmentID(@Param("name") String name, @Param("assignmentID") Integer assignmentID);

    @Query("Select u from StudentAssignment u where u.assignmentID = :assignmentID")
    List<StudentAssignment> findStudentAssignmentsByAssignmentID(@Param("assignmentID") Integer assignmentID);

}