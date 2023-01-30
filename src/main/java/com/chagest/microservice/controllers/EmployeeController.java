/**
 * @author Christian KEMGANG NGUESSOP
 * @version 1.0
 * @description Microservice using SpringBoot, MongoDB and React
 */

package com.chagest.microservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chagest.microservice.exceptions.EmployeeException;
import com.chagest.microservice.models.Employee;
import com.chagest.microservice.services.EmployeeService;

import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/v1")
//@AllArgsConstructor
public class EmployeeController {
	
	@Autowired 
	private EmployeeService eService;
	
	@GetMapping("/employees")
	public ResponseEntity<?> getEmployees(){
		List<Employee> employees = eService.getEmployees();
		return new ResponseEntity<>(employees, employees.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable("id") String id){
		try {
			return new ResponseEntity<>(eService.getEmployee(id), HttpStatus.OK);
		}catch(EmployeeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/employees")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
		try {
			eService.createEmployee(employee);
			return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
		} catch (ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (EmployeeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {
		try {
			eService.updateEmployee(id, employee);
			System.out.println("HELLO!!!");
			return new ResponseEntity<>("Successfully updating employee id= " + id, HttpStatus.OK);
		} catch (ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (EmployeeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") String id){
		try {
			eService.deleteEmployeeById(id);
			return new ResponseEntity<>("Successfully deleting employee id= " + id, HttpStatus.OK);
		} catch (EmployeeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
