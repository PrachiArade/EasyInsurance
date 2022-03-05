package perscholas.mycasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import perscholas.mycasestudy.form.LoginFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
public class LoginController {



    @GetMapping(value = "/login/loginSecurityPost")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessge = null;
        if(error != null) {
            errorMessge = "Username or Password is incorrect !!";
            model.addAttribute("errorMessage", errorMessge);
        }
        if(logout != null) {
            errorMessge = "You have been successfully logged out !!";
            model.addAttribute("logoutMsg", errorMessge);
        }

        return "/login/login";
    }




      @RequestMapping(value = {"/login/login"}, method = RequestMethod.GET)
       public ModelAndView login(HttpServletRequest request, HttpSession session, LoginFormBean formBean) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/login/login");

        return response;
        }

       @RequestMapping(value = "/login/logoutSuccess", method = RequestMethod.GET)
        public ModelAndView logoutSuccess(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
    //    response.setViewName("login/logoutSuccess");
            response.setViewName("login/logoutSuccess");

             return response;
        }

    }



