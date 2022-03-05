package perscholas.mycasestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import perscholas.mycasestudy.database.entity.PolicyHolder;

import java.util.List;

public interface PolicyHolderDAO extends JpaRepository<PolicyHolder,Integer> {

    List<PolicyHolder> findByEmail(String username);
}
