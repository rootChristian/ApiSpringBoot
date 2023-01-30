/**
 * @author Christian KEMGANG NGUESSOP
 * @version 1.0
 * @description Microservice using SpringBoot, MongoDB and React
 */

package com.chagest.microservice.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employees")
public class Employee {
	
	@Id
	private String id;

	@NotNull(message="Firstname cannot be null!")
	@Size(min=2, max=50)
	private String firstname;
	
	@NotNull(message="Lastname cannot be null!")
	@Size(min=2, max=50)
	private String lastname;
	
	@NotNull
	@Pattern(regexp="^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[a-z]{2,8}$", message="Invalid email address.") 
	private String email;
	
	@NotNull
	@Pattern(regexp="^(?=.*[a-z]{1,})(?=.*[A-Z]{1,})(?=.*[0-9]{1,})(?=.*[!@#\\$%\\^&\\*]).{8,}$", 
			message="Password incorrect, it's hould contain at least a small letter, a capital letter, a number, a special character and minimum length de 8.")
	private String password;
	  
	@NotNull(message="Address cannot be null, please use this format: yyyy-MM-dd.")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date age;
	 

	@NotNull(message="Address cannot be null.")
	private String address;
	
	@NotNull
	@Pattern(regexp="^\\d{8,15}$", message="Invalid phone number.")
	private String telephone;

	@NotNull(message="Role cannot be null.")
	private String role;
	
	@NotNull
	private Date createdAt;

	private Date updatedAt;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the age
	 */
	public Date getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Date age) {
		this.age = age;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	

}