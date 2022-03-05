package perscholas.mycasestudy.database.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import perscholas.mycasestudy.database.entity.User;
import perscholas.mycasestudy.database.entity.UserRole;

public interface UserRoleDAO extends JpaRepository <UserRole,Long> {

}
