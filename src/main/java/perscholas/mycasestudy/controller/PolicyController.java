package perscholas.mycasestudy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import perscholas.mycasestudy.database.dao.PolicyHolderDAO;
import perscholas.mycasestudy.database.dao.PolicyDAO;
import perscholas.mycasestudy.database.entity.PolicyHolder;
import perscholas.mycasestudy.form.LoginFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller

public class PolicyController {

    @Autowired
    private PolicyDAO policyRepo;

    @Autowired
    private PolicyHolderDAO policyHolderRepo;

    @GetMapping("/policies/{category}")
    public ModelAndView getPolicies(@PathVariable("category") String category){

        ModelAndView response = new ModelAndView();
        response.addObject("policies",policyRepo.findByCategory(category));
        response.setViewName("/insurance/individualPolicy");
        return response;
    }

    @GetMapping("/policies")
    public ModelAndView getPolicies(){

        ModelAndView response = new ModelAndView();
        response.addObject("policies",policyRepo.findAll());
        response.setViewName("/insurance/adminDashboard");
        return response;
    }

    @RequestMapping(value = {"/policy"}, method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpSession session, LoginFormBean formBean) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/policy/newpolicy");

        return response;
    }

    @GetMapping("/bookedPolicy")
    public ModelAndView bookedPolicy(){

        ModelAndView response = new ModelAndView();
        response.addObject("bookedPolicies",policyHolderRepo.findAll());
        response.setViewName("/insurance/BookedPolicyDashboard");
        return response;
    }

    //user

    @GetMapping("/userPolicy")
    public ModelAndView getUserPolicies(){
        ModelAndView response = new ModelAndView();
        response.setViewName("/policy/newUserPolicy");
        return response;
    }


    @RequestMapping(value = "/bookPolicy", method = RequestMethod.POST)
    public ModelAndView bookPolicy(@Valid PolicyHolder policyHolder, Authentication authentication)  {
        ModelAndView response = new ModelAndView();
        String username=null;

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();
        } else {
             username = principal.toString();
        }
        policyHolder.setEmail(username);
        List<PolicyHolder> policyHolderFound= policyHolderRepo.findByEmail(username);

        List<PolicyHolder> list=policyHolderFound.stream().filter(object->object.getCategory().equalsIgnoreCase(policyHolder.getCategory())
                && object.getCategoryName().equalsIgnoreCase(policyHolder.getCategoryName()) ).collect(Collectors.toList());

        if(list.size()>0){
            response.addObject("errorMsg", "You have already applied for same Policy..");
            response.setViewName("/policy/newUserPolicy");
            return response;
        }
        policyHolderRepo.save(policyHolder);
        response.addObject("policies", policyHolderRepo.findByEmail(username));
        response.setViewName("/insurance/property");
        return response;
    }

    @RequestMapping(value = "/deleteRecord/{policyId}",method = RequestMethod.GET)
    public ModelAndView deleteRecord(@PathVariable("policyId") Integer policyId){
        ModelAndView response = new ModelAndView();
        Optional<PolicyHolder> policyHolderOptional=  policyHolderRepo.findById(policyId);
        if(policyHolderOptional.isPresent()){
            policyHolderRepo.delete(policyHolderOptional.get());
        }
        response.addObject("bookedPolicies",policyHolderRepo.findAll());
        response.setViewName("/insurance/BookedPolicyDashboard");
        return response;
    }
}
