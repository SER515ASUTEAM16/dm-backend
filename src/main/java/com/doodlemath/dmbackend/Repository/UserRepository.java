package com.doodlemath.dmbackend.Repository;

import com.doodlemath.dmbackend.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * Repository class, which executes database queries related to the User
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("Select u from User u where LOWER(u.email) = LOWER(:email) and LOWER(u.password) = LOWER(:password)")
    List<User> findUserByEmail(@Param("email") String email, @Param("password") String password);

    @Query("Select u from User u where LOWER(u.name) = LOWER(:name) and LOWER(u.password) = LOWER(:password)")
    List<User> findUserByName(@Param("name") String name, @Param("password") String password);
}