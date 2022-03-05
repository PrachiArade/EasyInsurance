package perscholas.mycasestudy.database.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import perscholas.mycasestudy.database.entity.Insurance;
import perscholas.mycasestudy.database.entity.User;

import java.util.List;

public interface InsuranceDAO extends JpaRepository<Insurance, Long> {

 //   public List<Insurance> findByInsuranceNameIgnoreCase(@Param("insurance_name") String insurance_name);

 //   List<User> findByUser(User user, Sort sort);

}
