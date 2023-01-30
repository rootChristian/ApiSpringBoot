/**
 * @author Christian KEMGANG NGUESSOP
 * @version 1.0
 * @description Microservice using SpringBoot, MongoDB and React
 */

package com.chagest.microservice.exceptions;

public class EmployeeException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EmployeeException(String message) {
		super(message);
	}
	
	public static String NotFoundException(String id) {
		return "Employee with "+id+" not found!";
	}

	public static String EmployeeAlreadyExists() {
		return "Employee already exists!";
	}
}
