/**
 * @author Christian KEMGANG NGUESSOP
 * @version 1.0
 * @description Microservice using SpringBoot, MongoDB and React
 */

package com.chagest.microservice.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.chagest.microservice.models.Employee;

// we use MongoRepository to get accept of all method :(findAlll, getById, delete, save)  

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

	@Query("{'email': ?0 }")
	Optional<Employee> findByEmail(String email);
}
