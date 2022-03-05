package perscholas.mycasestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import perscholas.mycasestudy.database.entity.Policy;

import java.util.List;

public interface PolicyDAO extends JpaRepository<Policy,Integer> {

    List<Policy> findByPolicyName(String category);

    List<Policy> findByCategory(String category);
}
