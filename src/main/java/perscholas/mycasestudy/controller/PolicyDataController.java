package perscholas.mycasestudy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import perscholas.mycasestudy.database.dao.PolicyHolderDAO;
import perscholas.mycasestudy.database.dao.PolicyDAO;
import perscholas.mycasestudy.database.entity.Policy;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class PolicyDataController {

    @Autowired
    private PolicyDAO policyRepo;

    @Autowired
    private PolicyHolderDAO policyHolderRepo;

    @GetMapping("/AllPolicies")
    public Set<String> getPolicies(){
     return policyRepo.findAll().stream().map(Policy::getCategory).collect(Collectors.toSet());

    }

    @GetMapping("/policyName/{category}")
    public Set<String> getPoliciesName(@PathVariable("category") String category){
        return policyRepo.findByCategory(category).stream().map(Policy::getPolicyName).collect(Collectors.toSet());

    }


}
