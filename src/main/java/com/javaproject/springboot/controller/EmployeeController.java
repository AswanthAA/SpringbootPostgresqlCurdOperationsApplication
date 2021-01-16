package com.javaproject.springboot.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.springboot.model.Employee;
import com.javaproject.springboot.repository.EmployeeRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepo;
	
	//test
	
	@GetMapping("test/test1/test2")
	public String welcome(){
		
		return "test working";
	}
	//get All Employees
	
	
	@ApiOperation(value = "Finds all employees",
			notes = "Provides an All Employee details saved in the Database",
			response = Iterable.class)
	@GetMapping("employees")
	public List<Employee> getAllEmployees(){
		
		return this.employeeRepo.findAll();
	}
	//get A employee by ID
	@ApiOperation(value = "Finds employee with given EmployeId",
			notes = "Provides an Specific Employee details for given id",
			response = Employee.class)
	@GetMapping("employee/{employeeId}")
	public Employee getEmployeebyId(@ApiParam(value = "Unique Employee ID", required = true) 
									@PathVariable(value = "employeeId") int employeeId) throws RuntimeException{
		
		Employee employee = employeeRepo.findById(employeeId).orElseThrow(()-> new RuntimeException("Employee not found in db" +employeeId));
		
		return employee;
	}
	//Save a new employee
	
	@PostMapping("employee")
	@ApiOperation(value = "Saves a employee",
		notes = "Save a new Employee details given to API ",
		consumes = "Employee json",
		response = Employee.class)
	public Employee saveEmployee(@RequestBody Employee employee) {
		
		//In case if id is given in request body
		employee.setEmployeeId(0);
		return this.employeeRepo.save(employee);
	}
	
	//update a employee
	@PutMapping("employee")
	@ApiOperation(value = "Update an employee details",
		notes = "Update an Employee details based on given id ",
		consumes = "Employee json",
		response = Employee.class)
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeRepo.findById(employee.getEmployeeId())
		.orElseThrow(()-> new RuntimeException("Employee is not present in db " +employee.getEmployeeId()));
		
		return this.employeeRepo.save(employee);
	}
	
	//delete an employee
	@DeleteMapping("employee/{employeeId}")
	@ApiOperation(value = "Delete an employee",
		notes = "Delete an Employee details based on given id in DB",
		response = String.class)
	public String deleteEmployee(@PathVariable/*(value = "employeeId")*/ int employeeId)throws RuntimeException {
		
		Employee employee = employeeRepo.findById(employeeId)
				.orElseThrow(()-> new RuntimeException("Employee not found in db for deleting" +employeeId));
		
		this.employeeRepo.delete(employee);
		return "Deleted employee with id "+employeeId;
	}

}
