/**
 * @author Christian KEMGANG NGUESSOP
 * @version 1.0
 * @description Microservice using SpringBoot, MongoDB and React
 */

package com.chagest.microservice.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chagest.microservice.exceptions.EmployeeException;
import com.chagest.microservice.models.Employee;
import com.chagest.microservice.repositories.EmployeeRepository;



@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository eRepository;

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = eRepository.findAll();
		if (employees.size() > 0) {
			return employees;
		}else {
			return new ArrayList<Employee>();
		}
	}

	@Override
	public Employee getEmployee(String id) throws EmployeeException {
		Optional<Employee> emp = eRepository.findById(id);
		if (!emp.isPresent()) {
			throw new EmployeeException(EmployeeException.NotFoundException(id));
		}else {
			return emp.get();
		}
	}

	@Override
	public void createEmployee(Employee employee) throws EmployeeException {
		Optional<Employee> emp = eRepository.findByEmail(employee.getEmail());
		if(emp.isPresent()) {
			throw new EmployeeException(EmployeeException.EmployeeAlreadyExists());
		}else {
			employee.setCreatedAt(new Date(System.currentTimeMillis()));
			eRepository.save(employee);
		}
	}

	@Override
	public void updateEmployee(String id, Employee employee) throws EmployeeException {
		Optional<Employee> employeeId = eRepository.findById(id);
        Optional<Employee> employeWithSameName = eRepository.findByEmail(employee.getEmail());
        if(employeeId.isPresent())
        {
            if(employeWithSameName.isPresent() && !employeWithSameName.get().getId().equals(id))
            {
                throw new EmployeeException(EmployeeException.EmployeeAlreadyExists());
            }
            
            Employee employeeToUpdate=employeeId.get();
            
            employeeToUpdate.setFirstname(employee.getFirstname());
            employeeToUpdate.setLastname(employee.getLastname());
            employeeToUpdate.setEmail(employee.getEmail());
            employeeToUpdate.setAge(employee.getAge());
            employeeToUpdate.setAddress(employee.getAddress());
            employeeToUpdate.setTelephone(employee.getTelephone());
            employeeToUpdate.setRole(employee.getRole());
            employeeToUpdate.setUpdatedAt(new Date(System.currentTimeMillis()));
            eRepository.save(employeeToUpdate);
        }
        else
        {
            throw new EmployeeException(EmployeeException.NotFoundException(id));
        }
		
	}

	@Override
	public void deleteEmployeeById(String id) throws EmployeeException {
		Optional<Employee> employee = eRepository.findById(id);
        if(!employee.isPresent())
        {
            throw new EmployeeException(EmployeeException.NotFoundException(id));
        }
        else
        {
        	eRepository.deleteById(id);
        }
	}

	
}