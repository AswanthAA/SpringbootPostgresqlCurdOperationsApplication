package com.javaproject.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about an Employee")
@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	@ApiModelProperty(notes = "The unique id of the Employee class", name="employeeId",required=true)
	private int employeeId;

	@Column(name = "first_name")
	@ApiModelProperty(notes = "The First name of the Employee ")
	private String firstName;
	
	@ApiModelProperty(notes = "The Last name of the Employee ")
	@Column(name = "last_name")
	private String lastName;
	
	@ApiModelProperty(notes = "The Years of experience the Employee have ")
	@Column(name = "years_of_experience")
	private float yearsOfExperience;
	
	@ApiModelProperty(notes = "The email id of the Employee")
	@Column(name = "email")
	private String email;
	
	
	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, float yearsOfExperience, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearsOfExperience = yearsOfExperience;
		this.email = email;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public float getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(float yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
