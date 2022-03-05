package perscholas.mycasestudy.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.mycasestudy.database.dao.UserDAO;
import perscholas.mycasestudy.database.dao.UserRoleDAO;
import perscholas.mycasestudy.database.entity.User;
import perscholas.mycasestudy.database.entity.UserRole;
import perscholas.mycasestudy.form.RegisterFormBean;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {


    // make sure are import the slf4j object imports for this line of code
    public static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    //@Lazy
    private UserDAO userDao;

    @Autowired
    //@Lazy
    private UserRoleDAO userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public ModelAndView insurance() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("/registration/register");
        return response;
    }

    @RequestMapping(value = "/registerSubmit", method = RequestMethod.POST)
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();


        System.out.println(form);

        if (errors.hasErrors()) {

            List<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                form.getErrorMessages().add(error.getDefaultMessage());
                LOG.debug("error field = " + error.getField() + " message = " + error.getDefaultMessage());
            }


            response.addObject("errorMessages", errorMessages);

            response.addObject("formBeanKey", form);

            response.setViewName("registration/register");

            System.out.println("ERROR REGISTER");
        }

            else{
                User user;
                if (form.getId() == null) {
                    user = new User();
                }   else {
                    user = userDao.findById(form.getId());
                   }

                user.setFirstName(form.getFirstName());
                user.setLastName(form.getLastName());
                user.setEmail(form.getEmail());
                user.setPhone(form.getPhone());
                user.setPassword(form.getPassword());

                String encryptedPassword = passwordEncoder.encode(form.getPassword())  ;
                user.setPassword(encryptedPassword);
                user = userDao.save(user);
                if (form.getId() == null) {
                    UserRole ur = new UserRole();
                    ur.setUser(user);
                    ur.setUserRole(form.getUserType());
                    userRoleDao.save(ur);
                }

                userDao.save(user);
                response.setViewName("/login/login");

           // response.setViewName("registration/register");

        }

            return response;
        }
    }

