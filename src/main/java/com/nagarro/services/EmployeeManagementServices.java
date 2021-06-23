package com.nagarro.services;
/*
 * @Author Bhumika_Arora
 */
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.model.Employee;
import com.nagarro.utilities.Constants;

@Service
public class EmployeeManagementServices {
		
	RestTemplate restTemplate = new RestTemplate();
	
	public List<Employee> getEmployees() throws URISyntaxException {
		
		final List<Employee> listEmp = new ArrayList<Employee>();
		final Employee[] list = restTemplate.getForObject(Constants.URL_TYPE_GET_ALL, Employee[].class);
		  if (list != null) {
	            for (final Employee e1 : list) {
	            	final Employee emp=new Employee();
	            	emp.setId(e1.getId());
	            	emp.setEmpCode(e1.getEmpCode());
	    			emp.setEmpName(e1.getEmpName());
	    			emp.setEmpDOB(e1.getEmpDOB());
	    			emp.setEmpMail(e1.getEmpMail());
	    			emp.setEmpLoc(e1.getEmpLoc());
	    			listEmp.add(emp);
	            }
	        }
		
		return listEmp;
	}

	public Employee getEmployee(final long id) {
		final String url = Constants.URL_TYPE_GET_BY_ID + id;
		return restTemplate.getForObject(url, Employee.class);
	}
	
	public void updateEmployee(final Employee emp) {
		final String url = Constants.URL_TYPE_GET_BY_ID+ emp.getId();
		final HttpEntity<Employee> request = new HttpEntity<Employee>(emp);
		restTemplate.put(url, request);
	}
	
	public void addEmployee(final Employee emp) {
		final HttpEntity<Employee> request = new HttpEntity<Employee>(emp);
		restTemplate.postForObject(Constants.URL_TYPE_POST, request, Employee.class);
		
	}
	
	public void deleteEmployee(final long id) {
		final String url = Constants.URL_TYPE_GET_BY_ID + id;
	    restTemplate.delete(url);
	}	

}
