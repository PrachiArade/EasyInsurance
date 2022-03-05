package perscholas.mycasestudy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.mycasestudy.database.dao.UserDAO;

@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/user/profile", method = RequestMethod.GET)
    public ModelAndView profile() throws Exception {
        ModelAndView response = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        response.addObject("username", currentPrincipalName);
        response.setViewName("/user/profile");

        return response;
    }

}
