package perscholas.mycasestudy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholas.mycasestudy.database.dao.InsuranceDAO;
import perscholas.mycasestudy.database.entity.Insurance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class InsuranceController extends BaseController {

    @Autowired
    private InsuranceDAO insuranceDAO;


       @RequestMapping(value = {"/insurance","/"}, method = RequestMethod.GET)
       public ModelAndView insurance(HttpServletRequest request, HttpSession session) throws Exception{

        ModelAndView response = new ModelAndView();
        response.setViewName("/insurance/selectInsurance");

        return response;

    }
}

