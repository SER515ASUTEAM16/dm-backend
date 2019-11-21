package com.doodlemath.dmbackend.Repository;

import com.doodlemath.dmbackend.Model.StudentDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentTeacherRepository extends CrudRepository<StudentDetails, Integer> {

    @Query("Select u from StudentDetails u where LOWER(u.teacher) = LOWER(:teacher)")
    List<StudentDetails> findByTeacherName(@Param("teacher") String teacher);
}