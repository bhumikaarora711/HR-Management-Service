package com.nagarro.controller;
/*
 * @Author Bhumika_Arora
 */
import java.net.URISyntaxException; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.nagarro.model.Employee;
import com.nagarro.services.EmployeeManagementServices;
import com.nagarro.services.SignService;
import com.nagarro.utilities.Constants;

@Controller
@ControllerAdvice
public class SignInController {

	private static final String SIGNIN = "/signin";
	private static final String SIGNOUT = "/signout";

	@Autowired
	SignService signService;
	
	@Autowired
	EmployeeManagementServices empService;
	
	@RequestMapping(SIGNIN)
	public ModelAndView signIn(@RequestParam(Constants.USERNAME) final String username, @RequestParam(Constants.PASSWORD) final String password) throws URISyntaxException {
		
		final ModelAndView modelandview = new ModelAndView();
		if (signService.validateHRManager(username, password)) {
			modelandview.addObject(Constants.USERNAME, username);
			
			final List<Employee> employees = empService.getEmployees();
			modelandview.addObject(Constants.EMPLOYEES, employees);
			
			modelandview.setViewName(Constants.HOME);
		} else {
			modelandview.setViewName(Constants.INDEX_JSP_MSG_NO_USER_FOUND);
		}
		
		return modelandview;
	}
	
	@RequestMapping(SIGNOUT)
	public ModelAndView signOut() {
		final ModelAndView modelandview = new ModelAndView();
		modelandview.addObject(Constants.USERNAME, null);
		modelandview.setViewName(Constants.INDEX);
		return modelandview;
	}
	
}
