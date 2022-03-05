package perscholas.mycasestudy.database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import perscholas.mycasestudy.database.entity.User;
import perscholas.mycasestudy.database.entity.UserRole;


public interface UserDAO extends JpaRepository<User,Long> {


     User findById(@Param("id") Integer id);

     User findByEmail(@Param("email") String email);

    @Query("select ur from UserRole ur where ur.user.id = :userId")
    List<UserRole> getUserRoles(@Param("userId")  Integer userId);




}
