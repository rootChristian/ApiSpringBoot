/**
 * @author Christian KEMGANG NGUESSOP
 * @version 1.0
 * @description Microservice using SpringBoot, MongoDB and React
 */

package com.chagest.microservice.services;

import java.util.List;

import com.chagest.microservice.exceptions.EmployeeException;
import com.chagest.microservice.models.Employee;

public interface EmployeeService {
	
    public List<Employee> getEmployees();
	
	public Employee getEmployee(String id) throws EmployeeException;
	
	public void createEmployee(Employee employee) throws EmployeeException;
	
	public void updateEmployee(String id, Employee employee) throws EmployeeException;
	
	public void deleteEmployeeById(String id) throws EmployeeException;
	
}
