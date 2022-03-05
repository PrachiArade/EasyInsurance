package perscholas.mycasestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.mycasestudy.database.dao.PolicyHolderDAO;

import javax.servlet.http.HttpSession;

@Controller
public class InsuranceCoverController {

    @Autowired
    private PolicyHolderDAO policyHolderRepo;


    @RequestMapping(value = "/property" , method = RequestMethod.GET)
    public ModelAndView insurance(Authentication auth, HttpSession session) throws Exception{
        String username=null;
        ModelAndView response = new ModelAndView();
        Object principal = auth.getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        response.addObject("policies", policyHolderRepo.findByEmail(username));
        response.setViewName("/insurance/property");

        return response;
    }

}
