package com.doodlemath.dmbackend.Repository;

import com.doodlemath.dmbackend.Model.Assignment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * Repository class, which executes database queries related to the User
 */
@Repository
public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {

    @Query("Select u from Assignment u where LOWER(u.author) = LOWER(:author)")
    List<Assignment> findAssignmentsCreatedByAuthor(@Param("author") String author);
}