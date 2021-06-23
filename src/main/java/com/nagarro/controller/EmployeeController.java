package com.nagarro.controller;
/*
 * @Author Bhumika_Arora
 */
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.model.Employee;
import com.nagarro.services.EmployeeManagementServices;
import com.nagarro.utilities.Constants;

@Controller
public class EmployeeController {

	private static final String DOWNLOAD = "download";
	private static final String DELETE_EMPLOYEE = "delete-employee";
	private static final String UPLOAD = "upload";
	private static final String UPDATE = "update";
	private static final String EDIT_EMPLOYEE = "edit-employee";
	
	@Autowired
	EmployeeManagementServices empService;
	
	@RequestMapping(EDIT_EMPLOYEE)
	public ModelAndView EditEmployee(@RequestParam(Constants.ID) final long id, @RequestParam(Constants.USERNAME) final String username) {
		
		final ModelAndView mv = new ModelAndView();
		final Employee emp = empService.getEmployee(id);

		mv.addObject(Constants.EMPLOYEE, emp);
		mv.addObject(Constants.USERNAME, username);
		mv.setViewName(Constants.EDIT);
		return mv;
	}
	

	@RequestMapping(UPDATE)
	public ModelAndView updateEmployee(@RequestParam(Constants.ID) final long id, @RequestParam(Constants.EMP_CODE) final int empCode, @RequestParam(Constants.EMP_NAME) final String empName,
			@RequestParam(Constants.EMP_LOC) final String empLoc, @RequestParam(Constants.EMP_MAIL) final String empMail,
			@RequestParam(Constants.EMP_DOB) final String empDOB, @RequestParam(Constants.USERNAME) final String username) throws URISyntaxException {

		final ModelAndView mv = new ModelAndView();

		final Employee emp = new Employee();
		emp.setId(id);
		emp.setEmpCode(empCode);
		emp.setEmpName(empName);
		emp.setEmpLoc(empLoc);
		emp.setEmpMail(empMail);
		emp.setEmpDOB(empDOB);

		empService.updateEmployee(emp);

		final List<Employee> employees = empService.getEmployees();
		mv.addObject(Constants.EMPLOYEES, employees);

		mv.addObject(Constants.USERNAME, username);
		mv.setViewName(Constants.HOME);
		return mv;
	}
	
	@RequestMapping(UPLOAD)
	public ModelAndView uploadEmployee(@RequestParam(Constants.EMP_CODE) final int empCode, @RequestParam(Constants.EMP_NAME) final String empName, @RequestParam(Constants.EMP_LOC) final String empLoc,
			@RequestParam(Constants.EMP_MAIL) final String empMail, @RequestParam(Constants.EMP_DOB) final String empDOB,
			@RequestParam(Constants.USERNAME) final String username) throws URISyntaxException {

		final ModelAndView mv = new ModelAndView();

		final Employee emp = new Employee();
		emp.setEmpCode(empCode);
		emp.setEmpName(empName);
		emp.setEmpLoc(empLoc);
		emp.setEmpMail(empMail);
		emp.setEmpDOB(empDOB);

		empService.addEmployee(emp);

		final List<Employee> employees = empService.getEmployees();
		mv.addObject(Constants.EMPLOYEES, employees);

		mv.addObject(Constants.USERNAME, username);
		mv.setViewName(Constants.HOME);
		return mv;
	}
	

	@RequestMapping(DELETE_EMPLOYEE)
	public ModelAndView deleteEmployee(@RequestParam(Constants.ID) final long id, @RequestParam(Constants.USERNAME) final String username) throws URISyntaxException {

		final ModelAndView mv = new ModelAndView();

		empService.deleteEmployee(id);
		final List<Employee> employees = empService.getEmployees();
		mv.addObject(Constants.EMPLOYEES, employees);

		mv.addObject(Constants.USERNAME, username);
		mv.setViewName(Constants.HOME);

		return mv;
	}
	
	@RequestMapping(DOWNLOAD)
	public void downloadEmployeeList(final HttpServletRequest request, final HttpServletResponse response) throws URISyntaxException {
		
		final List<Employee> employees = empService.getEmployees();

		final String csvFileName = Constants.EMPLOYEES_CSV;
		response.setContentType(Constants.TEXT_CSV);
		final String key = Constants.CONTENT_DISPOSITION;
		final String value = String.format(Constants.ATTACHMENT_FILENAME_S, csvFileName);
		response.setHeader(key, value);
		ICsvBeanWriter csvWriter;

		try {
			csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
			final String[] headers = new String[] { Constants.EMP_CODE, Constants.EMP_NAME, Constants.EMP_LOC, Constants.EMP_MAIL, Constants.EMP_DOB };
			csvWriter.writeHeader(headers);
			for (final Employee employee : employees) {
				csvWriter.write(employee, headers);
			}
			csvWriter.close();
			
		} catch (final Exception e) {
			e.printStackTrace();
		} 

	}

	
}
